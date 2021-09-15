package ru.codavari.rickandmortyapp.base

import android.content.Context
import android.widget.Toast
import ru.gazpromneft.tenders.base.Navigator
import ru.gazpromneft.tenders.common.effect.Navigate
import ru.gazpromneft.tenders.common.effect.SetTargetResult
import ru.gazpromneft.tenders.common.effect.ToastMessage
import timber.log.Timber

interface Base <N : Navigator> {

    val navigator: N

    fun handleEffect(effect: UIEffect)
}

class BaseImpl<N : Navigator>(
    navigatorFactory: () -> N,
    private val requireContext: () -> Context
) : Base<N> {

    override val navigator: N by lazy(navigatorFactory)

    override fun handleEffect(effect: UIEffect) {
        when (effect) {
            is ToastMessage -> Toast.makeText(
                requireContext(), effect.text.asCharSequence(requireContext()), Toast.LENGTH_SHORT
            ).show()

            is Navigate -> with(effect) {
                navigate(navigator)
            }

            is SetTargetResult<*> -> with(effect) {
                Timber.d("target result key: ${effect.key}")
                navigator.setTargetResult(key, value)
            }

            else -> throw IllegalStateException("Unhandled effect ${effect::class.java.simpleName}")
        }
    }
}