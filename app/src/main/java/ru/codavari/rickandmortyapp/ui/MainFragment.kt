package ru.codavari.rickandmortyapp.ui

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