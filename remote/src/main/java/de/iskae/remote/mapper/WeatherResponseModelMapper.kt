package de.iskae.remote.mapper

import de.iskae.data.model.WeatherEntity
import de.iskae.remote.model.WeatherResponseModel

class WeatherResponseModelMapper : ModelMapper<WeatherResponseModel, WeatherEntity> {
    override fun mapFromModel(model: WeatherResponseModel): WeatherEntity {
        return WeatherEntity(
            latitude = model.coord.lat,
            longitude = model.coord.lon,
            description = model.weather[0].description, // Current weather has only one weather element
            iconId = model.weather[0].iconId,
            temperature = model.main.temp,
            pressure = model.main.pressure,
            tempMin = model.main.temp_min,
            tempMax = model.main.temp_max,
            windSpeed = model.wind.speed,
            windDegree = model.wind.deg,
            cloudinessPercentage = model.clouds.all,
            sunrise = model.sys.sunrise,
            sunset = model.sys.sunset
        )
    }

}