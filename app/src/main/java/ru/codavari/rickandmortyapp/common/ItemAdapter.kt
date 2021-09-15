package ru.codavari.rickandmortyapp.common

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import ru.codavari.rickandmortyapp.common.extensions.inflate

open class ItemAdapter(
    @LayoutRes val viewType: Int,
    val listener: Listener? = null
) {
    open fun onCreateViewHolder(parent: ViewGroup): BindingViewHolder {
        return BindingViewHolder(parent.inflate(viewType))
    }

    interface Listener
}
