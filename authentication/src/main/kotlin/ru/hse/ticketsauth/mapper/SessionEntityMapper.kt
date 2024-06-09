package ru.hse.ticketsauth.mapper

interface SessionEntityMapper {
    fun sessionEntityDaoToSessionEntityService(
        entity : ru.hse.ticketsauth.dao.entities.SessionEntity)
    : ru.hse.ticketsauth.services.entities.SessionEntity
}