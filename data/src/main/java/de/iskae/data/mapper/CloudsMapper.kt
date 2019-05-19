package de.iskae.data.mapper

import de.iskae.data.model.CloudsEntity
import de.iskae.domain.model.Clouds
import javax.inject.Inject

class CloudsMapper @Inject constructor() : EntityMapper<CloudsEntity, Clouds> {

    override fun mapFromEntity(entity: CloudsEntity): Clouds {
        return Clouds(cloudinessPercentage = entity.cloudinessPercentage)
    }

    override fun mapToEntity(domain: Clouds): CloudsEntity {
        return CloudsEntity(cloudinessPercentage = domain.cloudinessPercentage)
    }

}