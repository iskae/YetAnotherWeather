package de.iskae.yetanotherweather.core.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.iskae.yetanotherweather.MainActivity

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
