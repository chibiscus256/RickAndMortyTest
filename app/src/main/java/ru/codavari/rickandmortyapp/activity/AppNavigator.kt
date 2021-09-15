package ru.codavari.rickandmortyapp.activity

import ru.gazpromneft.tenders.base.Navigator
import androidx.navigation.NavController
import ru.codavari.rickandmortyapp.di.Global
import ru.gazpromneft.tenders.di.Global
import ru.gazpromneft.tenders.feature.coordinator.CoordinatorFragmentDirections
import ru.gazpromneft.tenders.feature.main.MainFragmentDirections
import javax.inject.Inject

class AppNavigator @Inject constructor(
    @Global navController: NavController
) : Navigator(navController) {

    fun navigateMain() = navController.navigate(
        CoordinatorFragmentDirections.navigateMain()
    )
}