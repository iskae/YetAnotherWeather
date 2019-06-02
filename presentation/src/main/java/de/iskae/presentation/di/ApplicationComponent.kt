package de.iskae.presentation.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import de.iskae.presentation.di.module.ApplicationModule
import de.iskae.presentation.di.module.CacheModule
import de.iskae.presentation.di.module.DataModule
import de.iskae.presentation.di.module.PresentationModule
import de.iskae.presentation.di.module.RemoteModule
import de.iskae.presentation.ui.YetAnotherWeatherApplication
import javax.inject.Singleton

@Singleton
@Component(
  modules = [AndroidInjectionModule::class,
    ApplicationModule::class,
    CacheModule::class,
    DataModule::class,
    PresentationModule::class,
    RemoteModule::class]
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