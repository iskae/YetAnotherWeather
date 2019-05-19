package de.iskae.data.mapper

import de.iskae.data.model.CoordEntity
import de.iskae.domain.model.Coord
import javax.inject.Inject

class CoordMapper @Inject constructor() : EntityMapper<CoordEntity, Coord> {

    override fun mapFromEntity(entity: CoordEntity): Coord {
        return Coord(
            lat = entity.lat,
            lon = entity.lon
        )
    }

    override fun mapToEntity(domain: Coord): CoordEntity {
        return CoordEntity(
            lat = domain.lat,
            lon = domain.lon
        )
    }
}