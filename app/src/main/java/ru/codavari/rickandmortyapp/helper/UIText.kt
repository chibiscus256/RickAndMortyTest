package ru.codavari.rickandmortyapp.helper

import android.content.Context

/**
 * Represents text that appears in ui.
 * @see [UIText.Companion.of]
 */
interface UIText {

    /**
     * @return [CharSequence] value of [UIText]
     */
    fun asCharSequence(context: Context): CharSequence

    companion object
}