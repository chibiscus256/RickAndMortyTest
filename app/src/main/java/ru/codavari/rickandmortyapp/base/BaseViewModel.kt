package ru.codavari.rickandmortyapp.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import ru.codavari.rickandmortyapp.common.extensions.launchCollect
import ru.codavari.rickandmortyapp.common.extensions.of
import ru.codavari.rickandmortyapp.data.common.AppCoroutineDispatchers
import ru.codavari.rickandmortyapp.helper.UIText
import ru.gazpromneft.tenders.base.Navigator
import ru.codavari.rickandmortyapp.common.effect.Navigate
import ru.codavari.rickandmortyapp.common.effect.SetTargetResult
import ru.codavari.rickandmortyapp.common.effect.ToastMessage
import timber.log.Timber

abstract class BaseViewModel<N : Navigator> : ViewModel() {

    protected val _effect = MutableSharedFlow<UIEffect>()
    val effect = _effect.asSharedFlow()

    val dispatchers: AppCoroutineDispatchers = AppCoroutineDispatchers.default()
    val main = dispatchers.main
    val default = dispatchers.default
    val io = dispatchers.io

    private var effectCollection: Job? = null
    fun subscribeOnEffect(collector: suspend (UIEffect) -> Unit) {
        effectCollection?.cancel()
        effectCollection = effect.launchCollect(viewModelScope, collector)
    }

    open fun handleError(throwable: Throwable) {
        Timber.e(throwable)
        showError(
            UIText.of(
                throwable.message ?: throwable::class.java.simpleName
            )
        )
    }

    fun showError(error: UIText) {
        launch(main) {
            _effect.emit(
                ToastMessage(error)
            )
        }
    }

    fun raiseEffect(eff: UIEffect) {
        launch(main) {
            _effect.emit(eff)
        }
    }

    fun <T> setTargetResult(key: String, value: T) {
        raiseEffect(SetTargetResult(key, value))
    }

    protected inline fun <T> observeTargetResult(
        key: String,
        crossinline collector: suspend (T) -> Unit
    ) {
        navigator {
            observeTargetResult<T>(key)
                ?.asFlow()
                ?.let { flow ->
                    launch(main) {
                        flow.collect(collector)
                    }
                }
        }
    }

    fun navigator(invoke: N.() -> Unit) {
        launch(main) {
            _effect.emit(
                Navigate { navigator ->
                    @Suppress("UNCHECKED_CAST")
                    (navigator as N).invoke()
                }
            )
        }
    }

    inline fun <T> runSafely(action: () -> T): T? {
        return try {
            action()
        } catch (throwable: Throwable) {
            handleError(throwable)
            null
        }
    }

    inline fun launch(
        dispatcher: CoroutineDispatcher,
        crossinline action: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(dispatcher) {
        runSafely { action() }
    }

    suspend inline fun <T> withContext(
        dispatcher: CoroutineDispatcher,
        crossinline action: suspend CoroutineScope.() -> T
    ): T? = kotlinx.coroutines.withContext(dispatcher) {
        runSafely { action() }
    }

    inline fun <T> async(
        dispatcher: CoroutineDispatcher,
        crossinline action: suspend CoroutineScope.() -> T
    ): Deferred<T?> = viewModelScope.async(dispatcher) {
        runSafely { action() }
    }
}