package com.kurt.example.rickandmorty.core.di

import ru.codavari.rickandmortyapp.repository.episodes.EpisodesRepository
import ru.codavari.rickandmortyapp.repository.episodes.EpisodesRepositoryImpl
import com.kurt.example.rickandmorty.core.framework.episodes.remote.EpisodesRemoteSourceImpl
import dagger.Binds
import dagger.Module

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 08/05/2019
 */
@Module
abstract class EpisodesModule {
    @Binds
    abstract fun provideEpisodesRepository(episodesRepositoryImpl: EpisodesRepositoryImpl): EpisodesRepository

    @Binds
    abstract fun provideEpisodesRemoteSource(episodesRemoteSourceImpl: EpisodesRemoteSourceImpl): EpisodesRepository
}