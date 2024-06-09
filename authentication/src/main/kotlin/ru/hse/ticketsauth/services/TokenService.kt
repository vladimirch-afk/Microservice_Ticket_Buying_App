package ru.hse.ticketsauth.services

import ru.hse.ticketsauth.services.entities.SessionEntity

interface TokenService {
    fun getTokenByUserId(id : Long) : String
    fun findSessionByToken(token : String) : SessionEntity
}