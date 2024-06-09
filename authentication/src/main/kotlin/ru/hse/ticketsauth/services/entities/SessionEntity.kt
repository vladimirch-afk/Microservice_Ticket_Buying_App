package ru.hse.ticketsauth.services.entities

import java.time.LocalDateTime

data class SessionEntity(
    val id : Long,
    val userId : Long,
    val token : String,
    val expireTime : LocalDateTime
)
