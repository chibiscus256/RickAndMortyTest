package ru.codavari.rickandmortyapp.ui.main

import ru.codavari.rickandmortyapp.R
import ru.codavari.rickandmortyapp.activity.AppNavigator
import ru.gazpromneft.tenders.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
) : BaseViewModel<AppNavigator>() {

    val bottomBarConfiguration = setOf(
        R.id.episodesListFragment,
        R.id.charactersListFragment,
        R.id.locationsListFragment
    )
}