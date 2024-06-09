package ru.hse.ticketsapp.mapper

import org.springframework.stereotype.Component

@Component
class StationEntityMapperImpl : StationEntityMapper {
    override fun stationEntityDaoToStationEntityService(entity: ru.hse.ticketsapp.dao.entities.StationEntity) =
        ru.hse.ticketsapp.services.entities.StationEntity(
            entity.id,
            entity.station
        )
}