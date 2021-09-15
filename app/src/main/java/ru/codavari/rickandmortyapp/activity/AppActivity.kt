package ru.codavari.rickandmortyapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ru.codavari.rickandmortyapp.R
import ru.codavari.rickandmortyapp.databinding.ActivityApplicationBinding
import ru.codavari.rickandmortyapp.di.ViewModelFactory
import ru.gazpromneft.tenders.activity.AppViewModel
import javax.inject.Inject

class AppActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<AppViewModel>

    lateinit var viewModel: AppViewModel

    lateinit var binding: ActivityApplicationBinding

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Tenders)
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_application
        )

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(AppViewModel::class.java)

        binding.viewModel = viewModel

        setupContent()
    }

    private fun setupContent() {
        findNavController().setGraph(R.navigation.app_nav_graph)
        //findNavController().setGraph(R.navigation.test_nav_graph)
    }

    fun findNavController() = (supportFragmentManager
        .findFragmentById(R.id.baseContainer) as NavHostFragment
            ).navController

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController()
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}