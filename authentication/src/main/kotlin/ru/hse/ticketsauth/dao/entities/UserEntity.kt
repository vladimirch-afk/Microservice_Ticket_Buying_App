package ru.hse.ticketsauth.dao.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("user")
data class UserEntity(
    @Id
    val id : Long?,
    val nickname : String,
    val email : String,
    val password : String,
    val created : LocalDateTime
)
