package ru.codavari.rickandmortyapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import ru.codavari.rickandmortyapp.activity.AppActivity
import ru.codavari.rickandmortyapp.activity.AppActivityGlobalModule
import ru.codavari.rickandmortyapp.ui.UIModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RepositoryModule::class,
    NetworkModule::class,
    ApiModule::class,
    AppActivityGlobalModule::class,
    ApplicationContextModule::class,
    UIModule::class
])
interface AppComponent : AndroidInjector<MobileApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent

        fun applicationContextModule(module: ApplicationContextModule): Builder
    }
}