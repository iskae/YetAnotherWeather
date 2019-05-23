package de.iskae.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.iskae.domain.feature.current.GetCurrentWeather
import de.iskae.domain.model.Weather
import de.iskae.presentation.mapper.WeatherPresentationMapper
import de.iskae.presentation.model.WeatherPresentation
import de.iskae.presentation.state.Resource
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class CurrentWeatherViewModel @Inject constructor(
  private val getCurrentWeather: GetCurrentWeather,
  private val mapper: WeatherPresentationMapper
) : ViewModel() {

  private val cityId = MutableLiveData<String>()
  private val currentWeather = MutableLiveData<Resource<WeatherPresentation>>()

  fun getCurrentWeather(): LiveData<Resource<WeatherPresentation>> {
    return currentWeather
  }

  private fun fetchCurrentWeather() {
    currentWeather.postValue(Resource.Loading())
    cityId.value?.let {
      //TODO: Use preferences for unit
      getCurrentWeather.execute(CurrentWeatherSubscriber(), GetCurrentWeather.Params.forCity(it, "metric"))
    }
  }

  fun setCityId(id: String) {
    cityId.value = id
    fetchCurrentWeather()
  }

  override fun onCleared() {
    getCurrentWeather.dispose()
    super.onCleared()
  }

  inner class CurrentWeatherSubscriber : DisposableObserver<Weather>() {
    override fun onNext(weather: Weather) {
      currentWeather.postValue(Resource.Success(mapper.mapToView(weather)))
    }

    override fun onComplete() {}
    override fun onError(throwable: Throwable) {
      currentWeather.postValue(Resource.Error(throwable))
    }
  }

}