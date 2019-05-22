package de.iskae.ui.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import de.iskae.presentation.viewmodel.CurrentWeatherViewModel
import de.iskae.ui.core.ViewModelFactory

@Module
abstract class PresentationModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CurrentWeatherViewModel::class)
    abstract fun bindCurrentWeatherViewModel(viewModel: CurrentWeatherViewModel): ViewModel


}
