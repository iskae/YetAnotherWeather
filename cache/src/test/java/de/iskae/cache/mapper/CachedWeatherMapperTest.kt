package de.iskae.cache.mapper

import de.iskae.cache.factory.WeatherDataFactory
import de.iskae.cache.model.CachedWeather
import de.iskae.data.model.WeatherEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CachedWeatherMapperTest {

  private val mapper = CachedWeatherMapper()

  @Test
  fun mapFromMapsData() {
    val cachedWeather = WeatherDataFactory.mockCachedWeather()
    val entity = mapper.mapFromCached(cachedWeather)

    assertDataEquals(cachedWeather, entity)
  }

  @Test
  fun mapToMapsData() {
    val entity = WeatherDataFactory.mockWeatherEntity()
    val cachedWeather = mapper.mapToCached(entity)

    assertDataEquals(cachedWeather, entity)
  }

  private fun assertDataEquals(cachedWeather: CachedWeather, weatherEntity: WeatherEntity) {
    assertThat(weatherEntity.id).isEqualTo(cachedWeather.id)
    assertThat(weatherEntity.latitude).isEqualTo(cachedWeather.latitude)
    assertThat(weatherEntity.longitude).isEqualTo(cachedWeather.longitude)
    assertThat(weatherEntity.description).isEqualTo(cachedWeather.description)
    assertThat(weatherEntity.iconId).isEqualTo(cachedWeather.iconId)
    assertThat(weatherEntity.temperature).isEqualTo(cachedWeather.temperature)
    assertThat(weatherEntity.pressure).isEqualTo(cachedWeather.pressure)
    assertThat(weatherEntity.tempMax).isEqualTo(cachedWeather.tempMax)
    assertThat(weatherEntity.tempMin).isEqualTo(cachedWeather.tempMin)
    assertThat(weatherEntity.windSpeed).isEqualTo(cachedWeather.windSpeed)
    assertThat(weatherEntity.windDegree).isEqualTo(cachedWeather.windDegree)
    assertThat(weatherEntity.cloudinessPercentage).isEqualTo(cachedWeather.cloudinessPercentage)
    assertThat(weatherEntity.sunrise).isEqualTo(cachedWeather.sunrise)
    assertThat(weatherEntity.sunset).isEqualTo(cachedWeather.sunset)
  }
}