package de.iskae.ui.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import de.iskae.ui.YetAnotherWeatherApplication
import de.iskae.ui.di.module.ApplicationModule
import de.iskae.ui.di.module.CacheModule
import de.iskae.ui.di.module.DataModule
import de.iskae.ui.di.module.PresentationModule
import de.iskae.ui.di.module.RemoteModule
import de.iskae.ui.di.module.UiModule
import javax.inject.Singleton

@Singleton
@Component(
  modules = arrayOf(
    AndroidInjectionModule::class,
    ApplicationModule::class,
    CacheModule::class,
    DataModule::class,
    PresentationModule::class,
    RemoteModule::class,
    UiModule::class
  )
)
interface ApplicationComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder

    fun build(): ApplicationComponent
  }

  fun inject(app: YetAnotherWeatherApplication)
}