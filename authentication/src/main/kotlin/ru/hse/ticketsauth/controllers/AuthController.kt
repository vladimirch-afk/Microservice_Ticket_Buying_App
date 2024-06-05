package ru.hse.ticketsauth.controllers

import ru.hse.ticketsauth.controllers.entities.InfoEntity

interface AuthController {
    fun createUser(userName : String, email : String, password : String)
    fun logIn(email : String, password : String) : String
    fun getInfo(token : String) : InfoEntity
}