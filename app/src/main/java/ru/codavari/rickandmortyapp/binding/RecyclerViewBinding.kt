package ru.codavari.rickandmortyapp.binding

import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.codavari.rickandmortyapp.common.Model
import ru.codavari.rickandmortyapp.common.ListAdapter

@BindingAdapter("data")
fun RecyclerView.setData(data: List<Model>?) {
    isVisible = data != null
    (adapter as? ListAdapter)?.apply {
        data?.let { items = it }
    }
}

@BindingAdapter("useDefaultAdapter")
fun RecyclerView.setDefaultAdapter(any: Any?) {
    adapter = ListAdapter()
}

@BindingAdapter(value = ["linearLayoutManager", "app:reverseLayout"], requireAll = false)
fun RecyclerView.setLinearLayoutManager(isHorizontal: Boolean, reverseLayout: Boolean = false) {
    val orientation = if (isHorizontal) {
        LinearLayoutManager.HORIZONTAL
    } else {
        LinearLayoutManager.VERTICAL
    }
    layoutManager = LinearLayoutManager(context, orientation, reverseLayout)
}

@BindingAdapter("scrollListener")
fun RecyclerView.setScrollListener(listener: ListAdapter.RecyclerViewScrollListener?) {
    listener ?: return

    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            if (dy > 0) {
                (recyclerView.layoutManager as? LinearLayoutManager)?.let {
                    listener.onScrolled(
                        it.findFirstVisibleItemPosition(),
                        it.findLastVisibleItemPosition()
                    )
                }
            }
        }
    })
}