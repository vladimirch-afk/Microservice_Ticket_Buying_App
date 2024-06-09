package ru.hse.ticketsauth.mapper

import org.springframework.stereotype.Component
import ru.hse.ticketsauth.services.entities.InfoEntity

@Component
class InfoEntityMapperImpl : InfoEntityMapper {
    override fun infoEntityServiceToInfoEntityController(entity: InfoEntity) =
            ru.hse.ticketsauth.controllers.entities.InfoEntity(
                entity.id,
                entity.name,
                entity.email
            )
}