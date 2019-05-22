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
    assertThat(weatherView.id).isEqualTo(model.id)
    assertThat(weatherView.latitude).isEqualTo(model.latitude)
    assertThat(weatherView.longitude).isEqualTo(model.longitude)
    assertThat(weatherView.description).isEqualTo(model.description)
    assertThat(weatherView.iconId).isEqualTo(model.iconId)
    assertThat(weatherView.temperature).isEqualTo(model.temperature)
    assertThat(weatherView.pressure).isEqualTo(model.pressure)
    assertThat(weatherView.tempMax).isEqualTo(model.tempMax)
    assertThat(weatherView.tempMin).isEqualTo(model.tempMin)
    assertThat(weatherView.windSpeed).isEqualTo(model.windSpeed)
    assertThat(weatherView.windDegree).isEqualTo(model.windDegree)
    assertThat(weatherView.cloudinessPercentage).isEqualTo(model.cloudinessPercentage)
    assertThat(weatherView.sunrise).isEqualTo(model.sunrise)
    assertThat(weatherView.sunset).isEqualTo(model.sunset)
  }
}