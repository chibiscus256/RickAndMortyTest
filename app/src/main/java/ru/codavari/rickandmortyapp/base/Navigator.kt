package ru.gazpromneft.tenders.base

import androidx.lifecycle.LiveData
import androidx.navigation.NavController

abstract class Navigator constructor(
    protected val navController: NavController
)  {
    fun <T> setTargetResult(key: String, value: T) = navController
        .previousBackStackEntry
        ?.savedStateHandle
        ?.set(key, value)

    fun <T> observeTargetResult(key: String): LiveData<T>? = navController
        .currentBackStackEntry
        ?.savedStateHandle
        ?.getLiveData(key)

    fun <T> removeKey(key: String): T? = navController
        .currentBackStackEntry
        ?.savedStateHandle
        ?.remove(key)

    fun back() {
        navController.navigateUp()
    }
}