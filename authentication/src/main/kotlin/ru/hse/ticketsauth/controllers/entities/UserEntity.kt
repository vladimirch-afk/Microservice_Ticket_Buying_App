package ru.hse.ticketsauth.controllers.entities

import java.time.LocalDateTime

data class UserEntity(
    val id : Long,
    val nickname : String,
    val email : String,
    val password : String,
    val created : LocalDateTime
)
