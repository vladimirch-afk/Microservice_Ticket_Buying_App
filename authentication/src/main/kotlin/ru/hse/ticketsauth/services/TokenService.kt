package ru.hse.ticketsauth.services

import org.springframework.stereotype.Component
import ru.hse.ticketsauth.entities.SessionEntity

@Component
interface TokenService {
    fun getToken(id : Int) : String
    fun checkToken(token : String) : SessionEntity
}