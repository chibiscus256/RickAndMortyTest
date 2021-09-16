package ru.codavari.rickandmortyapp.helper.text

import android.content.Context
import kotlinx.parcelize.Parcelize
import ru.codavari.rickandmortyapp.common.extensions.empty

@Parcelize
data class StringUIText(
    private val str: String?
) : ParcelableUIText {
    override fun asCharSequence(context: Context): CharSequence {
        return str ?: String.empty
    }
}
