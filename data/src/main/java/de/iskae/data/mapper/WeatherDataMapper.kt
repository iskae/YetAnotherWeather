package de.iskae.data.mapper

import de.iskae.data.model.WeatherDataEntity
import de.iskae.data.model.WeatherEntity
import de.iskae.domain.model.Weather
import de.iskae.domain.model.WeatherData
import javax.inject.Inject

class WeatherDataMapper @Inject constructor(
    private val cloudsMapper: CloudsMapper,
    private val coordMapper: CoordMapper,
    private val mainMapper: MainMapper,
    private val sysMapper: SysMapper,
    private val weatherMapper: WeatherMapper,
    private val windMapper: WindMapper
) :
    EntityMapper<WeatherDataEntity, WeatherData> {
    override fun mapFromEntity(entity: WeatherDataEntity): WeatherData {
        val weatherList = mutableListOf<Weather>()
        entity.weatherListEntity.forEach { weatherEntity -> weatherList.add(weatherMapper.mapFromEntity(weatherEntity)) }
        return WeatherData(
            clouds = cloudsMapper.mapFromEntity(entity = entity.cloudsEntity),
            coord = coordMapper.mapFromEntity(entity = entity.coordEntity),
            dt = entity.dtEntity,
            id = entity.idEntity,
            main = mainMapper.mapFromEntity(entity = entity.mainEntity),
            name = entity.nameEntity,
            sys = sysMapper.mapFromEntity(entity = entity.sysEntity),
            weatherList = weatherList,
            wind = windMapper.mapFromEntity(entity = entity.windEntity)
        )
    }

    override fun mapToEntity(domain: WeatherData): WeatherDataEntity {
        val weatherEntityList = mutableListOf<WeatherEntity>()
        domain.weatherList.forEach { weather -> weatherEntityList.add(weatherMapper.mapToEntity(weather)) }
        return WeatherDataEntity(
            cloudsEntity = cloudsMapper.mapToEntity(domain = domain.clouds),
            coordEntity = coordMapper.mapToEntity(domain = domain.coord),
            dtEntity = domain.dt,
            idEntity = domain.id,
            mainEntity = mainMapper.mapToEntity(domain = domain.main),
            nameEntity = domain.name,
            sysEntity = sysMapper.mapToEntity(domain = domain.sys),
            weatherListEntity = weatherEntityList,
            windEntity = windMapper.mapToEntity(domain = domain.wind)
        )
    }

}