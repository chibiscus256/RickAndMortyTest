package ru.codavari.rickandmortyapp.di

import dagger.Binds
import dagger.Module
import ru.codavari.rickandmortyapp.repository.characters.CharactersRepository
import ru.codavari.rickandmortyapp.repository.characters.CharactersRepositoryImpl

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 08/05/2019
 */
@Module
abstract class CharactersModule {
    @Binds
    abstract fun provideCharactersRepository(charactersRepositoryImpl: CharactersRepositoryImpl): CharactersRepository

}