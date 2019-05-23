package de.iskae.ui.currentweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import de.iskae.presentation.state.Resource
import de.iskae.presentation.viewmodel.CurrentWeatherViewModel
import de.iskae.ui.R
import de.iskae.ui.databinding.FragmentCurrentWeatherBinding
import de.iskae.ui.mapper.WeatherViewMapper
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class CurrentWeatherFragment : Fragment() {

  private val mapper: WeatherViewMapper by inject()
  private val currentWeatherViewModel: CurrentWeatherViewModel by viewModel()

  private lateinit var binding: FragmentCurrentWeatherBinding

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_current_weather, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    currentWeatherViewModel.setCityId("Berlin")
    currentWeatherViewModel.getCurrentWeather().observe(viewLifecycleOwner, Observer { weather ->
      when (weather) {
        is Resource.Loading -> Timber.d("loading")
        is Resource.Success -> {
          weather.data?.let {
            binding.weather = mapper.mapToView(it)
          }
        }
        is Resource.Error -> Timber.e(weather.throwable)
      }
    })
  }
}