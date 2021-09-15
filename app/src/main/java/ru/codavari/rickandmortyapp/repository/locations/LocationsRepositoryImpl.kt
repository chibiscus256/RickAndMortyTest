package ru.codavari.rickandmortyapp.repository.locations

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.codavari.rickandmortyapp.api.LocationsApi
import javax.inject.Inject

class LocationsRepositoryImpl @Inject constructor(
    private val api: LocationsApi
) : LocationsRepository {
    override suspend fun getAllLocations(page: Int?) = withContext(Dispatchers.IO) {
        api.getLocations(page).results
    }

    override suspend fun getLocation(locationId: Int) = withContext(Dispatchers.IO) {
        api.getLocation(locationId)
    }
}