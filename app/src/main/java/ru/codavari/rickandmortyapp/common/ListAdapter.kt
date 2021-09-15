package ru.gazpromneft.tenders.common.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.codavari.rickandmortyapp.common.BindingViewHolder
import ru.codavari.rickandmortyapp.common.ItemAdapter
import ru.gazpromneft.tenders.common.extensions.inflate

/**
 * You don't have to provide ItemAdapter for every viewType
 * @param itemAdapters For every Model that has listener or needs custom ViewHolder.
 */
class ListAdapter(
    vararg itemAdapters: ItemAdapter
) : RecyclerView.Adapter<BindingViewHolder>() {

    private val delegateAdapters = itemAdapters.associateBy { it.viewType }

    private val differ = AsyncListDiffer( this,
        object : DiffUtil.ItemCallback<Model>() {
            override fun areItemsTheSame(
                oldItem: Model, newItem: Model
            ) = oldItem.isTheSameAs(newItem)

            override fun areContentsTheSame(
                oldItem: Model, newItem: Model
            ) = oldItem.contentsAreTheSameAs(newItem)
        }
    )

    var items: List<Model>
        get() = differ.currentList
        set(value) = differ.submitList(value.toList())

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        return delegateAdapters[viewType]?.onCreateViewHolder(parent)
            ?: BindingViewHolder(parent.inflate(viewType))
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        items[position].let { item ->
            holder.bind(item, delegateAdapters[item.viewType]?.listener)
        }
    }

    override fun getItemCount() = items.size

    interface RecyclerViewScrollListener {
        fun onScrolled(firstVisibleItem: Int, lastVisibleItem: Int)
    }
}