package ru.hse.ticketsapp.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.ticketsapp.dao.entities.StationEntity

@Repository
interface StationEntityDao : CrudRepository<StationEntity, Long>