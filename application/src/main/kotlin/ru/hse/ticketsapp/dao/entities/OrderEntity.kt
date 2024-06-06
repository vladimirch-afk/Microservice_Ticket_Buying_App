package ru.hse.ticketsapp.dao.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("order")
data class OrderEntity(
    @Id
    val id: Long?,
    val userId: Long,
    val from: Long,
    val to: Long,
    val status: String,
    val created: LocalDateTime
)
