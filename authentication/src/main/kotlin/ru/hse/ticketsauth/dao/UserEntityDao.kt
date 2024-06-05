package ru.hse.ticketsauth.dao

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import ru.hse.ticketsauth.dao.entities.UserEntity
import java.util.Optional

@Component
interface UserEntityDao : CrudRepository<UserEntity, Long> {
    fun getUserEntityByEmail(email : String) : Optional<UserEntity>
}