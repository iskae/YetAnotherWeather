package de.iskae.data.mapper

import de.iskae.data.model.MainEntity
import de.iskae.domain.model.Main
import javax.inject.Inject

class MainMapper @Inject constructor() : EntityMapper<MainEntity, Main> {

    override fun mapFromEntity(entity: MainEntity): Main {
        return Main(
            humidity = entity.humidity,
            pressure = entity.pressure,
            temp = entity.temp,
            tempMax = entity.tempMax,
            tempMin = entity.tempMin
        )
    }

    override fun mapToEntity(domain: Main): MainEntity {
        return MainEntity(
            humidity = domain.humidity,
            pressure = domain.pressure,
            temp = domain.temp,
            tempMax = domain.tempMax,
            tempMin = domain.tempMin
        )
    }
}