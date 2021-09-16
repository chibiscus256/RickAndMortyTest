package ru.codavari.rickandmortyapp.common.effect

import ru.codavari.rickandmortyapp.base.UIEffect

data class SetTargetResult<T>(val key: String, val value: T) : UIEffect()
