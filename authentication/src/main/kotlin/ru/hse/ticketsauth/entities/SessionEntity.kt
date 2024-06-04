package ru.hse.ticketsauth.entities

import java.time.LocalDateTime

data class SessionEntity(
    val userId : Long,
    val token : String,
    val expireTime : LocalDateTime
)
