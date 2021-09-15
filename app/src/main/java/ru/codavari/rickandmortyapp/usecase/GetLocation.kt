package ru.codavari.rickandmortyapp.usecase

import ru.codavari.rickandmortyapp.repository.locations.LocationsRepository
import javax.inject.Inject

class GetLocation @Inject constructor(private val locationsRepository: LocationsRepository) {
    suspend operator fun invoke(locationId: Int) = locationsRepository.getLocation(locationId)
}