package de.iskae.ui.di.module

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.iskae.domain.executor.PostExecutionThread
import de.iskae.ui.MainActivity
import de.iskae.ui.UiThread
import de.iskae.ui.currentweather.CurrentWeatherFragment

@Module
abstract class UiModule {
    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributesCurrentWeatherFragment(): CurrentWeatherFragment

}