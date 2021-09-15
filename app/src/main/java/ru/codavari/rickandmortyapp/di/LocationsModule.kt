package ru.codavari.rickandmortyapp.di

import dagger.Binds
import dagger.Module
import ru.codavari.rickandmortyapp.repository.locations.LocationsRepository
import ru.codavari.rickandmortyapp.repository.locations.LocationsRepositoryImpl

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 08/05/2019
 */
@Module
abstract class LocationsModule {
    @Binds
    abstract fun provideLocationsRepository(locationsRepositoryImpl: LocationsRepositoryImpl): LocationsRepository
}