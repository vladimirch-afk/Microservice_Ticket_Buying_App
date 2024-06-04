package ru.hse.ticketsauth.services

import org.springframework.stereotype.Service

@Service
class AuthServiceImpl : AuthService {
    override fun createUser(userName: String, email: String, password: String) {
        val
    }

    override fun authUser(email: String, password: String): Int {
        TODO("Not yet implemented")
    }

    override fun getInfo(token: String): String {
        TODO("Not yet implemented")
    }
}