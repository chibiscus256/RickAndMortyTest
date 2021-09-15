package ru.codavari.rickandmortyapp.di

import android.app.Application
import android.content.res.Configuration
import android.os.Build
import android.os.StrictMode
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ru.codavari.rickandmortyapp.BuildConfig
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class MobileApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        @Suppress("deprecation")
        resources.updateConfiguration(
            Configuration().apply {
                setLocale(MobileApplication.locale)
                setLayoutDirection(MobileApplication.locale)
            },
            null
        )
        Locale.setDefault(locale)

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectActivityLeaks()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .apply {
                        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
                            detectContentUriWithoutPermission()
                        }
                    }.build()
            )
        }
        super.onCreate()
        DaggerAppComponent.builder()
            .context(this)
            .applicationContextModule(ApplicationContextModule(this))
            .build()
            .inject(this)
        Timber.plant(Timber.DebugTree())
    }

    override fun androidInjector() = dispatchingAndroidInjector

    companion object {
        val locale = Locale("ru", "RU")
    }
}