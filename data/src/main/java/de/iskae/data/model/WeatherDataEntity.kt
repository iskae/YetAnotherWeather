package de.iskae.data.model

class WeatherDataEntity(
    val cloudsEntity: CloudsEntity,
    val coordEntity: CoordEntity,
    val dtEntity: Int,
    val idEntity: Int,
    val mainEntity: MainEntity,
    val nameEntity: String,
    val sysEntity: SysEntity,
    val weatherListEntity: List<WeatherEntity>,
    val windEntity: WindEntity
)