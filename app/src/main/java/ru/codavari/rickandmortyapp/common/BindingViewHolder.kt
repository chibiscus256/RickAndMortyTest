package ru.codavari.rickandmortyapp.common

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ru.codavari.rickandmortyapp.BR

open class BindingViewHolder(
    open val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    open fun bind(model: Model, listener: ItemAdapter.Listener?) {
        binding.apply {
            setVariable(BR.item, model.item)
            setVariable(BR.listener, listener)
            setVariable(BR.position, bindingAdapterPosition)
        }
    }
}