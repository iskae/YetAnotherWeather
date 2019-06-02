package de.iskae.presentation.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import de.iskae.domain.executor.PostExecutionThread
import de.iskae.presentation.core.ViewModelFactory
import de.iskae.presentation.ui.MainActivity
import de.iskae.presentation.ui.UiThread
import de.iskae.presentation.ui.currentweather.CurrentWeatherFragment
import de.iskae.presentation.ui.hourlyforecast.HourlyForecastFragment
import de.iskae.presentation.ui.settings.SettingsFragment
import de.iskae.presentation.viewmodel.CurrentWeatherViewModel

@Module
abstract class PresentationModule {

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

  @Binds
  abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

  @Binds
  @IntoMap
  @ViewModelKey(CurrentWeatherViewModel::class)
  abstract fun bindCurrentWeatherViewModel(viewModel: CurrentWeatherViewModel): ViewModel

  @ContributesAndroidInjector
  abstract fun contributesMainActivity(): MainActivity

  @ContributesAndroidInjector
  abstract fun contributesCurrentWeatherFragment(): CurrentWeatherFragment

  @ContributesAndroidInjector
  abstract fun contributesHourlyForecastFragment(): HourlyForecastFragment

  @ContributesAndroidInjector
  abstract fun contributesSettingsFragment(): SettingsFragment

}
