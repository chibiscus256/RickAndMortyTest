package ru.codavari.rickandmortyapp.common.extensions

import ru.codavari.rickandmortyapp.utils.Separator

inline val String.Companion.empty get() = ""

inline val String.Companion.space get() = " "

fun String.breakLine() = replaceFirst(Separator.SPACE, Separator.NEXT_LINE)

fun String.replace(index: Int, c: Char) = replaceRange(index, index + 1, "$c")
