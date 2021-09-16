package ru.codavari.rickandmortyapp.helper.text

import android.content.Context
import kotlinx.parcelize.Parcelize
import ru.codavari.rickandmortyapp.common.extensions.empty

@Parcelize
data class ResourceUIText(
    private val res: Int?
) : ParcelableUIText {
    override fun asCharSequence(context: Context): CharSequence {
        return res?.let { context.resources.getText(res) } ?: String.empty
    }
}
