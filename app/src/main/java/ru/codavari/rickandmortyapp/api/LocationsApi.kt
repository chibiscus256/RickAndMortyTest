package ru.codavari.rickandmortyapp.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.codavari.rickandmortyapp.data.Location
import ru.codavari.rickandmortyapp.data.RickAndMortyResponse

interface LocationsApi {
    @GET("location/")
    suspend fun getLocations(@Query("page") page: Int?): RickAndMortyResponse<Location>

    @GET("location/{locationId}")
    suspend fun getLocation(@Path("locationId") locationId: Int): Location
}