package ru.hse.ticketsauth.services

interface AuthService {
    fun createUser(userName : String, email : String, password : String)
    fun authUser(email : String, password : String) : Int
    fun getInfo(token : String) : String
}