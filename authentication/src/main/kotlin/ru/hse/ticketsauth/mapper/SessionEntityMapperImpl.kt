package ru.hse.ticketsauth.mapper

import org.springframework.stereotype.Component

@Component
class SessionEntityMapperImpl : SessionEntityMapper {
    override fun sessionEntityDaoToSessionEntityService(
        entity : ru.hse.ticketsauth.dao.entities.SessionEntity
    ) = ru.hse.ticketsauth.services.entities.SessionEntity(
        entity.id!!,
        entity.userId,
        entity.token,
        entity.expireTime
    )
}