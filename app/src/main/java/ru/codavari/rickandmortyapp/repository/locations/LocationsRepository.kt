package ru.codavari.rickandmortyapp.repository.locations

import ru.codavari.rickandmortyapp.data.Location

interface LocationsRepository {
    suspend fun getAllLocations(page: Int? = null): List<Location>
    suspend fun getLocation(locationId: Int): Location
}