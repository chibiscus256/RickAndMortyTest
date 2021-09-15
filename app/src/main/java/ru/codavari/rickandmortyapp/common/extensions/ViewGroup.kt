package ru.codavari.rickandmortyapp.common.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.forEach
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun ViewGroup.inflate(@LayoutRes layout: Int): ViewDataBinding =
    DataBindingUtil.inflate(
        LayoutInflater.from(this.context),
        layout,
        this,
        false
    )

fun ViewGroup.forEachChild(action: View.() -> Unit) {
    forEach { child ->
        if (child is ViewGroup)
            child.forEachChild(action)

        child.action()
    }
}

@BindingAdapter("showOverlay")
fun ViewGroup.showOverlay(value: Boolean) {
    if (value) {
        forEachChild { isEnabled = false }
        alpha = 0.5f
    } else {
        forEachChild { isEnabled = true }
        alpha = 1f
    }
}