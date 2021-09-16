package ru.codavari.rickandmortyapp.di

import dagger.Binds
import dagger.Module
import ru.codavari.rickandmortyapp.repository.characters.CharactersRepository
import ru.codavari.rickandmortyapp.repository.characters.CharactersRepositoryImpl
import ru.codavari.rickandmortyapp.repository.episodes.EpisodesRepository
import ru.codavari.rickandmortyapp.repository.episodes.EpisodesRepositoryImpl
import ru.codavari.rickandmortyapp.repository.locations.LocationsRepository
import ru.codavari.rickandmortyapp.repository.locations.LocationsRepositoryImpl

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideEpisodesRepository(episodesRepositoryImpl: EpisodesRepositoryImpl): EpisodesRepository

    @Binds
    abstract fun provideLocationsRepository(locationsRepositoryImpl: LocationsRepositoryImpl): LocationsRepository

    @Binds
    abstract fun provideCharactersRepository(charactersRepositoryImpl: CharactersRepositoryImpl): CharactersRepository

}