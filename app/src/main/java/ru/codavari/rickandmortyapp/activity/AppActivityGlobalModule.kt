package ru.codavari.rickandmortyapp.activity

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.codavari.rickandmortyapp.di.AppScope
import ru.codavari.rickandmortyapp.di.Global
import ru.codavari.rickandmortyapp.di.Main

@Module
class AppActivityGlobalModule {

    @Global
    @AppScope
    @Provides
    fun provideNavController(activity: AppActivity) = activity.findNavController()

    @Main
    @AppScope
    @Provides
    fun provideContext(activity: AppActivity): Context = activity
}
