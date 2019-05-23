package de.iskae.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import de.iskae.domain.feature.current.GetCurrentWeather
import de.iskae.presentation.mapper.WeatherPresentationMapper
import de.iskae.presentation.viewmodel.CurrentWeatherViewModel

class CurrentWeatherViewModelFactory(
  private val getCurrentWeather: GetCurrentWeather,
  private val mapper: WeatherPresentationMapper
) :
  ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(CurrentWeatherViewModel::class.java)) {
      return CurrentWeatherViewModel(getCurrentWeather, mapper) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }

}