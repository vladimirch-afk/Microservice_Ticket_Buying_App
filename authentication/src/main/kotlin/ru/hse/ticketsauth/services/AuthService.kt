package ru.hse.ticketsauth.services

import ru.hse.ticketsauth.services.entities.InfoEntity

interface AuthService {
    fun createUser(userName : String, email : String, password : String)
    fun authUser(email : String, password : String) : ru.hse.ticketsauth.services.entities.UserEntity
    fun getInfo(token : String) : InfoEntity
}