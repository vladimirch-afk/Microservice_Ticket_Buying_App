package ru.hse.ticketsauth.controllers

interface AuthController {
    fun createUser(userName : String, email : String, password : String) : String
    fun logIn(email : String, password : String) : String
    fun getInfo(token : String) : String
}