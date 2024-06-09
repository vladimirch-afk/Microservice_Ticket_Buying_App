package ru.hse.ticketsauth.jwt

interface TokenGenerator {
    // Сгенерировать токен
    fun generateToken(payload : String) : String
}