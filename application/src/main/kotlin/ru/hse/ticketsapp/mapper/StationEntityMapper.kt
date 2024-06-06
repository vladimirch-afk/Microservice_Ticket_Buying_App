package ru.hse.ticketsapp.mapper

interface StationEntityMapper {
    fun stationEntityDaoToStationEntityService(entity: ru.hse.ticketsapp.dao.entities.StationEntity) :
        ru.hse.ticketsapp.services.entities.StationEntity
}