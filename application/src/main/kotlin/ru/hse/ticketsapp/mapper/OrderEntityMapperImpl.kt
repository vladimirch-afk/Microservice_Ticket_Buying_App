package ru.hse.ticketsapp.mapper

import org.springframework.stereotype.Component

@Component
class OrderEntityMapperImpl : OrderEntityMapper {
    override fun infoDaoEntityToInfoServiceEntity(entity: ru.hse.ticketsapp.dao.entities.OrderEntity) =
        ru.hse.ticketsapp.services.entities.OrderEntity(
            entity.id,
            entity.userId,
            entity.fromStationId,
            entity.toStationId,
            entity.status,
            entity.created
        )

    override fun infoServiceEntityToInfoDaoEntity(entity: ru.hse.ticketsapp.services.entities.OrderEntity) =
        ru.hse.ticketsapp.dao.entities.OrderEntity(
            null,
            entity.userId,
            entity.from,
            entity.to,
            entity.status,
            entity.created
        )
}