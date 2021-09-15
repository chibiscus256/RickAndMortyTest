package ru.gazpromneft.tenders.activity

import ru.gazpromneft.tenders.base.Navigator
import androidx.navigation.NavController
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

    fun navigateOnboarding() = navController.navigate(
        CoordinatorFragmentDirections.navigateOnboarding()
    )

    fun navigateNewPassword(email: String, checkword: String) = navController.navigate(
        CoordinatorFragmentDirections.navigateNewPasswordFragment(email, checkword)
    )
}