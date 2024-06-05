package ru.hse.ticketsauth.dao.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("session_table")
data class SessionEntity(
    @Id
    val id : Long?,
    val userId : Long,
    val token : String,
    val expireTime : LocalDateTime
)
