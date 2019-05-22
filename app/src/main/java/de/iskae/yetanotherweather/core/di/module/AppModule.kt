package de.iskae.yetanotherweather.core.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module(includes = [LeakCanaryModule::class, ViewModelModule::class])
abstract class AppModule {
  @Binds
  abstract fun providesContext(application: Application): Context
}