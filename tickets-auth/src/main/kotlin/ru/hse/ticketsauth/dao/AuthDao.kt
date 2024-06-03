package ru.hse.ticketsauth.dao

interface AuthDao {
    fun findById(id : Int) : Int
}