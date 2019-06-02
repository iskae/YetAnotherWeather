package de.iskae.presentation.mapper

import de.iskae.domain.model.Weather
import de.iskae.presentation.factory.WeatherFactory
import de.iskae.presentation.model.WeatherView
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WeatherViewMapperTest {

  private val mapper = WeatherViewMapper()

  @Test
  fun mapToViewMapsData() {
    val weather = WeatherFactory.mockWeather()
    val weatherView = mapper.mapToView(weather)

    assertDataEquals(weather, weatherView)
  }

  private fun assertDataEquals(model: Weather, weatherView: WeatherView) {
    assertThat(model.id).isEqualTo(weatherView.id)
    assertThat(model.name).isEqualTo(weatherView.name)
    assertThat(model.latitude).isEqualTo(weatherView.latitude)
    assertThat(model.longitude).isEqualTo(weatherView.longitude)
    assertThat(model.description).isEqualTo(weatherView.description)
    assertThat(model.icon).isEqualTo(weatherView.icon)
    assertThat(model.temperature).isEqualTo(weatherView.temperature.toDouble())
    assertThat(model.pressure).isEqualTo(weatherView.pressure.toInt())
    assertThat(model.tempMax).isEqualTo(weatherView.tempMax.toDouble())
    assertThat(model.tempMin).isEqualTo(weatherView.tempMin.toDouble())
    assertThat(model.windSpeed).isEqualTo(weatherView.windSpeed.toDouble())
    assertThat(model.windDegree).isEqualTo(weatherView.windDegree.toInt())
    assertThat(model.cloudinessPercentage).isEqualTo(weatherView.cloudinessPercentage.toInt())
    assertThat(model.sunrise).isEqualTo(weatherView.sunrise.toLong())
    assertThat(model.sunset).isEqualTo(weatherView.sunset.toLong())
  }
}