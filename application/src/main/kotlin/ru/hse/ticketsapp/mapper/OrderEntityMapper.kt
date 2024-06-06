package ru.hse.ticketsapp.mapper

interface OrderEntityMapper {
    fun infoDaoEntityToInfoServiceEntity(entity: ru.hse.ticketsapp.dao.entities.OrderEntity):
            ru.hse.ticketsapp.services.entities.OrderEntity
    fun infoServiceEntityToInfoDaoEntity(entity:  ru.hse.ticketsapp.services.entities.OrderEntity):
            ru.hse.ticketsapp.dao.entities.OrderEntity
}