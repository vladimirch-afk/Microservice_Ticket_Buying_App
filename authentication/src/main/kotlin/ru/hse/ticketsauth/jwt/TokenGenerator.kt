package ru.hse.ticketsauth.jwt

interface TokenGenerator {
    fun generateToken(payload : String) : String
}