package ru.hse.ticketsapp.dao.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("order")
data class OrderEntity(
    @Id
    val id: Long?,
    val userId: Long,
    val fromStationId: Long,
    val toStationId: Long,
    val status: Int,
    val created: LocalDateTime
)
