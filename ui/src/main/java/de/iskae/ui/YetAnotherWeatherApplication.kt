package de.iskae.ui

import android.app.Application
import android.content.Context
import de.iskae.ui.di.appModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import timber.log.Timber

class YetAnotherWeatherApplication : Application(), KodeinAware {

  override fun onCreate() {
    super.onCreate()
    setupTimber()
  }

  private fun setupTimber() {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }

  override val kodein = Kodein.lazy {
    bind<Context>("ApplicationContext") with singleton { this@YetAnotherWeatherApplication.applicationContext }
    bind<YetAnotherWeatherApplication>() with singleton { this@YetAnotherWeatherApplication }
    import(appModule(this@YetAnotherWeatherApplication))
  }

}