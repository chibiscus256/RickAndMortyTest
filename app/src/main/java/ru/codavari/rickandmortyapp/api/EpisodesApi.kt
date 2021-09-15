package ru.codavari.rickandmortyapp.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.codavari.rickandmortyapp.data.Episode
import ru.codavari.rickandmortyapp.data.RickAndMortyResponse

interface EpisodesApi {
    @GET("episode/")
    suspend fun getAllEpisodes(@Query("page") page: Int? = null): RickAndMortyResponse<Episode>

    @GET("episode/{episodeIds}")
    suspend fun getEpisodes(@Path("episodeIds") episodeIds: List<Int>): List<Episode>

    @GET("episode/{episodeId}")
    suspend fun getEpisode(@Path("episodeId") episodeId: Int): Episode
}