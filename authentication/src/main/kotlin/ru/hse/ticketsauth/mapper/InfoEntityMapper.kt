package ru.hse.ticketsauth.mapper

interface InfoEntityMapper {
    fun infoEntityServiceToInfoEntityController(
        entity : ru.hse.ticketsauth.services.entities.InfoEntity)
            : ru.hse.ticketsauth.controllers.entities.InfoEntity
}