package ru.hse.ticketsapp.services

import ru.hse.ticketsapp.services.entities.StationEntity

interface StationService {
    fun findStationByName(station: String) : StationEntity
}