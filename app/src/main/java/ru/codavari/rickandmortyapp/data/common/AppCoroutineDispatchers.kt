package ru.codavari.rickandmortyapp.data.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

data class AppCoroutineDispatchers(
    val main: CoroutineDispatcher,
    val default: CoroutineDispatcher,
    val io: CoroutineDispatcher
) {
    companion object {
        fun default() = AppCoroutineDispatchers(
            main = Dispatchers.Main,
            default = Dispatchers.Default,
            io = Dispatchers.IO
        )
    }
}
