package de.iskae.data.mapper

import de.iskae.data.model.WindEntity
import de.iskae.domain.model.Wind
import javax.inject.Inject

class WindMapper @Inject constructor() : EntityMapper<WindEntity, Wind> {
    override fun mapFromEntity(entity: WindEntity): Wind {
        return Wind(
            deg = entity.deg,
            speed = entity.speed
        )
    }

    override fun mapToEntity(domain: Wind): WindEntity {
        return WindEntity(
            deg = domain.deg,
            speed = domain.speed
        )
    }
}