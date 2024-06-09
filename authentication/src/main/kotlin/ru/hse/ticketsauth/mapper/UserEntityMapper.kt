package ru.hse.ticketsauth.mapper

interface UserEntityMapper {
    fun userEntityDaoToUserEntityService(
        entity : ru.hse.ticketsauth.dao.entities.UserEntity)
            : ru.hse.ticketsauth.services.entities.UserEntity

    fun userEntityServiceToInfoEntity(
        entity : ru.hse.ticketsauth.services.entities.UserEntity
    ) : ru.hse.ticketsauth.services.entities.InfoEntity
}