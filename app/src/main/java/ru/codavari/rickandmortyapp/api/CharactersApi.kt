package ru.codavari.rickandmortyapp.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.codavari.rickandmortyapp.data.RickAndMortyResponse
import ru.codavari.rickandmortyapp.data.Character

interface CharactersApi {
    @GET("character/")
    suspend fun getAllCharacters(@Query("page") page: Int? = null): RickAndMortyResponse<Character>

    @GET("character/{characterIds}")
    suspend fun getCharacters(@Path("characterIds") characterIds: List<Int>): List<Character>

    @GET("character/{characterId}")
    suspend fun getCharacter(@Path("characterId") characterId: Int): Character
}