package ru.codavari.rickandmortyapp.data

data class RickAndMortyResponse<T>(
    val info: Info,
    val results: List<T>
)