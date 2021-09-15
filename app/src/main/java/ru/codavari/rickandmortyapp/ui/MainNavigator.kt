package ru.codavari.rickandmortyapp.ui

import androidx.navigation.NavController
import ru.codavari.rickandmortyapp.di.Global
import ru.gazpromneft.tenders.base.Navigator
import javax.inject.Inject

class MainNavigator @Inject constructor(
    @Global navController: NavController
) : Navigator(navController) {

}