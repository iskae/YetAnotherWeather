package de.iskae.ui

import android.app.Application
import de.iskae.ui.di.applicationModule
import de.iskae.ui.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class YetAnotherWeatherApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidLogger()
      androidContext(this@YetAnotherWeatherApplication)
      modules(applicationModule, dataModule)
    }
    setupTimber()
  }

  private fun setupTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }

}