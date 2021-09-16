package ru.codavari.rickandmortyapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationShort(
    val name: String,
    val url: String
): Parcelable