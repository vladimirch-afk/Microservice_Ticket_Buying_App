package ru.hse.ticketsapp.services.entities

import java.time.LocalDateTime

data class OrderEntity(
    val id: Long?,
    val userId: Long,
    val from: Long,
    val to: Long,
    val status: Int,
    val created: LocalDateTime
)