package de.iskae.data.mapper

import de.iskae.data.factory.WeatherFactory
import de.iskae.data.model.WeatherEntity
import de.iskae.domain.model.Weather
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WeatherDataMapperTest {

  private val weatherMapper = WeatherMapper()

  @Test
  fun mapFromEntityMapsData() {
    val entity = WeatherFactory.mockWeatherEntity()
    val model = weatherMapper.mapFromEntity(entity)
    assertEqualData(entity, model)
  }

  @Test
  fun mapToEntityMapsData() {
    val model = WeatherFactory.mockWeather()
    val entity = weatherMapper.mapToEntity(model)
    assertEqualData(entity, model)
  }

  private fun assertEqualData(entity: WeatherEntity, model: Weather) {
    assertThat(entity.id).isEqualTo(model.id)
    assertThat(entity.name).isEqualTo(model.name)
    assertThat(entity.latitude).isEqualTo(model.latitude)
    assertThat(entity.longitude).isEqualTo(model.longitude)
    assertThat(entity.description).isEqualTo(model.description)
    assertThat(entity.icon).isEqualTo(model.icon)
    assertThat(entity.temperature).isEqualTo(model.temperature)
    assertThat(entity.pressure).isEqualTo(model.pressure)
    assertThat(entity.tempMax).isEqualTo(model.tempMax)
    assertThat(entity.tempMin).isEqualTo(model.tempMin)
    assertThat(entity.windSpeed).isEqualTo(model.windSpeed)
    assertThat(entity.windDegree).isEqualTo(model.windDegree)
    assertThat(entity.cloudinessPercentage).isEqualTo(model.cloudinessPercentage)
    assertThat(entity.sunrise).isEqualTo(model.sunrise)
    assertThat(entity.sunset).isEqualTo(model.sunset)
  }
}