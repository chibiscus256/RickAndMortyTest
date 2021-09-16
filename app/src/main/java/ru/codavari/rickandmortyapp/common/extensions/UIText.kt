package ru.codavari.rickandmortyapp.common.extensions

import ru.codavari.rickandmortyapp.helper.UIText
import ru.codavari.rickandmortyapp.helper.text.EmptyUIText
import ru.codavari.rickandmortyapp.helper.text.ParcelableUIText
import ru.codavari.rickandmortyapp.helper.text.ResourceUIText
import ru.codavari.rickandmortyapp.helper.text.StringUIText

fun UIText.Companion.of(res: Int?): ParcelableUIText = ResourceUIText(res)

fun UIText.Companion.of(str: String?): ParcelableUIText = StringUIText(str)

val UIText.Companion.empty: UIText get() = EmptyUIText