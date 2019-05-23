package de.iskae.ui.currentweather

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import dagger.android.support.AndroidSupportInjection
import de.iskae.presentation.state.Resource
import de.iskae.presentation.viewmodel.CurrentWeatherViewModel
import de.iskae.ui.R
import de.iskae.ui.databinding.FragmentCurrentWeatherBinding
import de.iskae.ui.mapper.WeatherViewMapper
import timber.log.Timber
import javax.inject.Inject

class CurrentWeatherFragment : Fragment() {

  @Inject lateinit var mapper: WeatherViewMapper
  @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
  private val viewModel: CurrentWeatherViewModel by navGraphViewModels(R.id.navGraphMain) { viewModelFactory }

  private lateinit var binding: FragmentCurrentWeatherBinding

  override fun onAttach(context: Context) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_current_weather, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.setCityId("Berlin")
    viewModel.getCurrentWeather().observe(viewLifecycleOwner, Observer { weather ->
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