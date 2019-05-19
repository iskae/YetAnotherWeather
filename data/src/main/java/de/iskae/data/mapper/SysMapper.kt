package de.iskae.data.mapper

import de.iskae.data.model.SysEntity
import de.iskae.domain.model.Sys
import javax.inject.Inject

class SysMapper @Inject constructor() : EntityMapper<SysEntity, Sys> {
    override fun mapFromEntity(entity: SysEntity): Sys {
        return Sys(
            country = entity.country,
            sunrise = entity.sunrise,
            sunset = entity.sunset,
            type = entity.type
        )
    }

    override fun mapToEntity(domain: Sys): SysEntity {
        return SysEntity(
            country = domain.country,
            sunrise = domain.sunrise,
            sunset = domain.sunset,
            type = domain.type
        )
    }
}