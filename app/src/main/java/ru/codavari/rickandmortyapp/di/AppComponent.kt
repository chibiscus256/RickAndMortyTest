package ru.codavari.rickandmortyapp.di

import android.content.Context
import com.kurt.example.rickandmorty.core.di.EpisodesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

/**
 * Copyright 2019, Kurt Renzo Acosta, All rights reserved.
 *
 * @author Kurt Renzo Acosta
 * @since 08/06/2019
 */
@Component(modules = [
    CharactersModule::class,
    EpisodesModule::class,
    LocationsModule::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<MobileApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent

        fun applicationContextModule(module: ApplicationContextModule): Builder
    }
}