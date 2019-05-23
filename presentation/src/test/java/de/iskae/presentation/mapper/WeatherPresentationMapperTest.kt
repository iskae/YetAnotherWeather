package de.iskae.presentation.mapper

import de.iskae.domain.model.Weather
import de.iskae.presentation.factory.WeatherFactory
import de.iskae.presentation.model.WeatherPresentation
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WeatherPresentationMapperTest {

  private val mapper = WeatherPresentationMapper()

  @Test
  fun mapToViewMapsData() {
    val weather = WeatherFactory.mockWeather()
    val weatherView = mapper.mapToView(weather)

    assertDataEquals(weather, weatherView)
  }

  private fun assertDataEquals(model: Weather, weatherPresentation: WeatherPresentation) {
    assertThat(weatherPresentation.id).isEqualTo(model.id)
    assertThat(weatherPresentation.name).isEqualTo(model.name)
    assertThat(weatherPresentation.latitude).isEqualTo(model.latitude)
    assertThat(weatherPresentation.longitude).isEqualTo(model.longitude)
    assertThat(weatherPresentation.description).isEqualTo(model.description)
    assertThat(weatherPresentation.icon).isEqualTo(model.icon)
    assertThat(weatherPresentation.temperature).isEqualTo(model.temperature)
    assertThat(weatherPresentation.pressure).isEqualTo(model.pressure)
    assertThat(weatherPresentation.tempMax).isEqualTo(model.tempMax)
    assertThat(weatherPresentation.tempMin).isEqualTo(model.tempMin)
    assertThat(weatherPresentation.windSpeed).isEqualTo(model.windSpeed)
    assertThat(weatherPresentation.windDegree).isEqualTo(model.windDegree)
    assertThat(weatherPresentation.cloudinessPercentage).isEqualTo(model.cloudinessPercentage)
    assertThat(weatherPresentation.sunrise).isEqualTo(model.sunrise)
    assertThat(weatherPresentation.sunset).isEqualTo(model.sunset)
  }
}