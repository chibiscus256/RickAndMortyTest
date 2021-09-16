package ru.codavari.rickandmortyapp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.codavari.rickandmortyapp.api.CharactersApi
import ru.codavari.rickandmortyapp.api.EpisodesApi
import ru.codavari.rickandmortyapp.api.LocationsApi
import javax.inject.Singleton

@Module
class ApiModule {

    private inline operator fun <reified T> Retrofit.invoke() = create(T::class.java)

    @Provides
    @Singleton
    fun provideEpisodesApi(retrofit: Retrofit): EpisodesApi = retrofit()

    @Provides
    @Singleton
    fun provideCharactersApi(retrofit: Retrofit): CharactersApi = retrofit()

    @Provides
    @Singleton
    fun provideLocationsApi(retrofit: Retrofit): LocationsApi = retrofit()
}