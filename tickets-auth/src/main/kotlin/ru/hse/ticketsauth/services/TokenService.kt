package ru.hse.ticketsauth.services

import org.springframework.stereotype.Component

@Component
interface TokenService {
    fun getToken(id : Int) : String
}