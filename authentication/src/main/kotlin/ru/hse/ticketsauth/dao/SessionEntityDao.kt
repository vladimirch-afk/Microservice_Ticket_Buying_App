package ru.hse.ticketsauth.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import ru.hse.ticketsauth.dao.entities.SessionEntity
import java.util.Optional

@Component
interface SessionEntityDao : CrudRepository<SessionEntity, Long> {
    fun getByToken(token : String) : Optional<SessionEntity>
    fun getByUserId(id : Long) : Optional<SessionEntity>
}