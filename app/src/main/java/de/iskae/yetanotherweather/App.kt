package de.iskae.yetanotherweather

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import de.iskae.yetanotherweather.core.di.component.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        val applicationComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        applicationComponent.inject(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector
}
