package ru.codavari.rickandmortyapp.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import ru.codavari.rickandmortyapp.R
import ru.codavari.rickandmortyapp.common.Model

@Parcelize
@JsonClass(generateAdapter = true)
data class Character(
    val created: String,
    @Json(name = "episode")
    val episodes: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationShort,
    val origin: LocationShort,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
): Model(R.layout.list_item_character), Parcelable