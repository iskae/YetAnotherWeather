package de.iskae.data.mapper

import de.iskae.data.factory.WeatherFactory
import de.iskae.data.model.WeatherDataEntity
import de.iskae.domain.model.WeatherData
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert
import org.junit.Test

class WeatherDataMapperTest {

    private val weatherDataMapper = WeatherDataMapper(
        cloudsMapper = CloudsMapper(),
        coordMapper = CoordMapper(),
        mainMapper = MainMapper(),
        sysMapper = SysMapper(),
        weatherMapper = WeatherMapper(),
        windMapper = WindMapper()
    )

    @Test
    fun mapFromEntityMapsData() {
        val entity = WeatherFactory.mockWeatherDataEntity()
        val model = weatherDataMapper.mapFromEntity(entity)
        assertEqualData(entity, model)
    }

    @Test
    fun mapToEntityMapsData() {
        val model = WeatherFactory.mockWeatherData()
        val entity = weatherDataMapper.mapToEntity(model)
        assertEqualData(entity, model)
    }

    private fun assertEqualData(entity: WeatherDataEntity, model: WeatherData) {
        assertThat(entity.idEntity).isEqualTo(model.id)
        assertThat(entity.dtEntity).isEqualTo(model.dt)
        Assert.assertEquals(entity.nameEntity, model.name)


        assertThat(entity.cloudsEntity.cloudinessPercentage).isEqualTo(model.clouds.cloudinessPercentage)

        assertThat(entity.coordEntity.lat).isEqualTo(model.coord.lat)
        assertThat(entity.coordEntity.lon).isEqualTo(model.coord.lon)

        assertThat(entity.mainEntity.humidity).isEqualTo(model.main.humidity)
        assertThat(entity.mainEntity.pressure).isEqualTo(model.main.pressure)
        assertThat(entity.mainEntity.temp).isEqualTo(model.main.temp)
        assertThat(entity.mainEntity.tempMax).isEqualTo(model.main.tempMax)
        assertThat(entity.mainEntity.tempMin).isEqualTo(model.main.tempMin)

        Assert.assertEquals(entity.sysEntity.country, model.sys.country)
        assertThat(entity.sysEntity.sunrise).isEqualTo(model.sys.sunrise)
        assertThat(entity.sysEntity.sunset).isEqualTo(model.sys.sunset)
        assertThat(entity.sysEntity.type).isEqualTo(model.sys.type)

        entity.weatherListEntity.forEachIndexed { index, weatherListEntity ->
            assertThat(weatherListEntity.description).isEqualTo(model.weatherList[index].description)
            assertThat(weatherListEntity.iconId).isEqualTo(model.weatherList[index].iconId)
            assertThat(weatherListEntity.id).isEqualTo(model.weatherList[index].id)
            assertThat(weatherListEntity.main).isEqualTo(model.weatherList[index].main)
        }
        assertThat(entity.weatherListEntity.size).isEqualTo(model.weatherList.size)

        assertThat(entity.windEntity.deg).isEqualTo(model.wind.deg)
        assertThat(entity.windEntity.speed).isEqualTo(model.wind.speed)
    }
}