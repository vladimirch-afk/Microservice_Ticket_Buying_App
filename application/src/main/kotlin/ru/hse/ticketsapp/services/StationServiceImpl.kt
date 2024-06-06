package ru.hse.ticketsapp.services

import org.springframework.stereotype.Service
import ru.hse.ticketsapp.dao.StationEntityDao
import ru.hse.ticketsapp.mapper.StationEntityMapper

@Service
class StationServiceImpl(
    val stationEntityDao: StationEntityDao,
    val stationEntityMapper: StationEntityMapper
) : StationService {
    override fun findStationByName(station: String): ru.hse.ticketsapp.services.entities.StationEntity {
        val res : ru.hse.ticketsapp.services.entities.StationEntity
        try {
            val tmp = stationEntityDao.findByStation(station).get()
            res = stationEntityMapper.stationEntityDaoToStationEntityService(tmp)
        } catch (e: Exception) {
            throw RuntimeException("Station not found")
        }
        return res
    }
}