package ru.codavari.rickandmortyapp.usecase

import ru.codavari.rickandmortyapp.repository.locations.LocationsRepository
import javax.inject.Inject

class GetAllLocations @Inject constructor(private val locationsRepository: LocationsRepository) {
    suspend operator fun invoke(page: Int? = null) = locationsRepository.getAllLocations(page)
}