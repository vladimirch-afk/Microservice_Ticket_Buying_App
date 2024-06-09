package ru.hse.ticketsapp.api

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import ru.hse.ticketsapp.controllers.entities.InfoEntity

@FeignClient(name="application", url="authentication:8080")
@Component
interface AuthenticationApi {

    // Получить информацию о пользователе от другого микросервиса
    @GetMapping("/info/{token}")
    fun getUserInfo(@PathVariable token: String): InfoEntity
}