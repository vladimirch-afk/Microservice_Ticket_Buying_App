package ru.hse.ticketsauth.dao

import org.springframework.stereotype.Repository

@Repository
class AuthDaoImpl : AuthDao {
    override fun findById(id: Int): Int {
        TODO("Not yet implemented")
    }
}