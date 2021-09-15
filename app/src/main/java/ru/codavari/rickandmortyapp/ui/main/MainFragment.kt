package ru.codavari.rickandmortyapp.ui.main

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.codavari.rickandmortyapp.R
import ru.codavari.rickandmortyapp.base.BaseFragment
import ru.codavari.rickandmortyapp.databinding.FragmentMainBinding
import ru.codavari.rickandmortyapp.activity.AppNavigator

class MainFragment : BaseFragment<FragmentMainBinding, AppNavigator, MainViewModel>(
    MainViewModel::class.java,
    R.layout.fragment_main,
    ::AppNavigator
) {
    override fun onBind() {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.mainNavHost) as NavHostFragment

        val navController = navHostFragment.navController

        binding.mainBottomNav.setupWithNavController(navController)
    }
}