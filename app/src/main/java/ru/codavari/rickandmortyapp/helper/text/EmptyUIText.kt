package ru.codavari.rickandmortyapp.helper.text

import android.content.Context
import kotlinx.parcelize.Parcelize
import ru.codavari.rickandmortyapp.common.extensions.empty

@Parcelize
object EmptyUIText : ParcelableUIText {
    override fun asCharSequence(context: Context): CharSequence {
        return String.empty
    }
}