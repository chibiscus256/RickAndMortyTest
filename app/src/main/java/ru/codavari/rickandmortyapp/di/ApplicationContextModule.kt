package ru.codavari.rickandmortyapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationContextModule(private val context: Context) {

    @Singleton
    @Application
    @Provides
    fun provideAppContext(): Context = context
}