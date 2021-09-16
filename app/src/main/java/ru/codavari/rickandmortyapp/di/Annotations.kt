package ru.codavari.rickandmortyapp.di

import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
@Retention(value = AnnotationRetention.RUNTIME)
annotation class Global

@Qualifier
@Retention(value = AnnotationRetention.RUNTIME)
annotation class Main

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class AppScope

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Qualifier
@Retention(value = AnnotationRetention.RUNTIME)
annotation class Application