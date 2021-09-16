package ru.codavari.rickandmortyapp.activity

import androidx.navigation.NavController
import ru.codavari.rickandmortyapp.di.Global
import ru.gazpromneft.tenders.base.Navigator
import javax.inject.Inject

class AppNavigator @Inject constructor(
    @Global navController: NavController
) : Navigator(navController) {

/*    fun navigateMain() = navController.navigate(
        CoordinatorFragmentDirections.navigateMain()
    )*/
}