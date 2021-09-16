package ru.codavari.rickandmortyapp.common.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun <T> Flow<T>.launchCollect(
    scope: CoroutineScope,
    collector: suspend (T) -> Unit
) = scope.launch {
    collect(collector)
}