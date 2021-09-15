package ru.codavari.rickandmortyapp.common

abstract class Model(
    val viewType: Int
) {

    open val item: Any get() = this

    open fun isTheSameAs(other: Model): Boolean {
        return this === other
    }

    open fun contentsAreTheSameAs(other: Model): Boolean {
        return this == other
    }
}