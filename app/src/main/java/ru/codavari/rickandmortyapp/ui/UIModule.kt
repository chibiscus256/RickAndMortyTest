package ru.codavari.rickandmortyapp.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.codavari.rickandmortyapp.di.FragmentScope
import ru.codavari.rickandmortyapp.ui.characters.CharacterDetailsFragment
import ru.codavari.rickandmortyapp.ui.characters.CharactersListFragment
import ru.codavari.rickandmortyapp.ui.episodes.EpisodeDetailsFragment
import ru.codavari.rickandmortyapp.ui.episodes.EpisodesListFragment
import ru.codavari.rickandmortyapp.ui.locations.LocationDetailsFragment
import ru.codavari.rickandmortyapp.ui.locations.LocationsListFragment
import ru.codavari.rickandmortyapp.ui.main.MainFragment

@Module
abstract class UIModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun charactersListFragment(): CharactersListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun characterDetailsFragment(): CharacterDetailsFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun episodeDetailsFragment(): EpisodeDetailsFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun episodesListFragment(): EpisodesListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun locationsListFragment(): LocationsListFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun locationDetailsFragment(): LocationDetailsFragment
}