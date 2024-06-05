package ru.hse.ticketsauth.mapper

import org.springframework.stereotype.Component
import ru.hse.ticketsauth.services.entities.InfoEntity
import ru.hse.ticketsauth.services.entities.UserEntity

@Component
class UserEntityMapperImpl : UserEntityMapper {
    override fun userEntityDaoToUserEntityService(
        entity: ru.hse.ticketsauth.dao.entities.UserEntity) =
        ru.hse.ticketsauth.services.entities.UserEntity(
        entity.id!!,
        entity.nickname,
        entity.email,
        entity.password,
        entity.created
    )

    override fun userEntityServiceToInfoEntity(entity: UserEntity) =
        ru.hse.ticketsauth.services.entities.InfoEntity(
            entity.id,
            entity.nickname,
            entity.email,
        )
}