package de.iskae.remote.mapper

import de.iskae.remote.factory.WeatherDataFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WeatherResponseModelMapperTest {

  private val mapper = WeatherResponseModelMapper()

  @Test
  fun mapFromModelMapsData() {
    val responseModel = WeatherDataFactory.mockWeatherResponseModel()
    val entity = mapper.mapFromModel(responseModel)

    assertThat(responseModel.id).isEqualTo(entity.id)
    assertThat(responseModel.clouds.all).isEqualTo(entity.cloudinessPercentage)
    assertThat(responseModel.coord.lat).isEqualTo(entity.latitude)
    assertThat(responseModel.coord.lon).isEqualTo(entity.longitude)
    assertThat(responseModel.main.temp).isEqualTo(entity.temperature)
    assertThat(responseModel.main.temp_max).isEqualTo(entity.tempMax)
    assertThat(responseModel.main.temp_min).isEqualTo(entity.tempMin)
    assertThat(responseModel.weather[0].description).isEqualTo(entity.description)
    assertThat(responseModel.weather[0].iconId).isEqualTo(entity.iconId)
    assertThat(responseModel.sys.sunrise).isEqualTo(entity.sunrise)
    assertThat(responseModel.sys.sunset).isEqualTo(entity.sunset)
  }
}