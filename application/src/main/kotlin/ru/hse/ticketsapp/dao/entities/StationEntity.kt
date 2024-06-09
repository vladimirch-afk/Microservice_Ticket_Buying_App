package ru.hse.ticketsapp.dao.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("station")
data class StationEntity(
    @Id
    val id: Long?,
    val station: String
)