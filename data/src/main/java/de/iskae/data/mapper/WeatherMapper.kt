package de.iskae.data.mapper

import de.iskae.data.model.WeatherEntity
import de.iskae.domain.model.Weather
import javax.inject.Inject

class WeatherMapper @Inject constructor() : EntityMapper<WeatherEntity, Weather> {

    override fun mapFromEntity(entity: WeatherEntity): Weather {
        return Weather(
            id = entity.id,
            main = entity.main,
            description = entity.description,
            iconId = entity.iconId
        )
    }

    override fun mapToEntity(domain: Weather): WeatherEntity {
        return WeatherEntity(
            id = domain.id,
            main = domain.main,
            description = domain.description,
            iconId = domain.iconId
        )
    }
}