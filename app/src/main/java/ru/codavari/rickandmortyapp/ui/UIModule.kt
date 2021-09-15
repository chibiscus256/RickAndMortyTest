package ru.codavari.rickandmortyapp.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.codavari.rickandmortyapp.di.FragmentScope

@Module
abstract class UIModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment
}