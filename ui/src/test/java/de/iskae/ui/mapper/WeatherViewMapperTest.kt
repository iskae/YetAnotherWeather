package de.iskae.ui.mapper

import de.iskae.presentation.model.WeatherPresentation
import de.iskae.ui.model.WeatherView
import de.iskae.ui.test.mock.WeatherMockFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WeatherViewMapperTest {

  private val mapper = WeatherViewMapper()

  @Test
  fun mapToViewMapsData() {
    val weatherPresentation = WeatherMockFactory.mockWeatherPresentation()
    val weatherView = mapper.mapToView(weatherPresentation)

    assertDataEquals(weatherView, weatherPresentation)
  }

  private fun assertDataEquals(weatherView: WeatherView, weatherPresentation: WeatherPresentation) {
    assertThat(weatherPresentation.id).isEqualTo(weatherView.id)
    assertThat(weatherPresentation.name).isEqualTo(weatherView.name)
    assertThat(weatherPresentation.latitude).isEqualTo(weatherView.latitude)
    assertThat(weatherPresentation.longitude).isEqualTo(weatherView.longitude)
    assertThat(weatherPresentation.description).isEqualTo(weatherView.description)
    assertThat(weatherPresentation.icon).isEqualTo(weatherView.icon)
    assertThat(weatherPresentation.temperature).isEqualTo(weatherView.temperature.toDouble())
    assertThat(weatherPresentation.pressure).isEqualTo(weatherView.pressure.toInt())
    assertThat(weatherPresentation.tempMax).isEqualTo(weatherView.tempMax.toDouble())
    assertThat(weatherPresentation.tempMin).isEqualTo(weatherView.tempMin.toDouble())
    assertThat(weatherPresentation.windSpeed).isEqualTo(weatherView.windSpeed.toDouble())
    assertThat(weatherPresentation.windDegree).isEqualTo(weatherView.windDegree.toInt())
    assertThat(weatherPresentation.cloudinessPercentage).isEqualTo(weatherView.cloudinessPercentage.toInt())
    assertThat(weatherPresentation.sunrise).isEqualTo(weatherView.sunrise.toLong())
    assertThat(weatherPresentation.sunset).isEqualTo(weatherView.sunset.toLong())
  }
}