package ru.hse.ticketsauth.controllers

import org.springframework.http.ResponseEntity
import ru.hse.ticketsauth.controllers.entities.InfoEntity

interface AuthController {
    // Создать пользователя
    fun createUser(userName : String, email : String, password : String) : ResponseEntity<String>
    // Зайти за пользователя
    fun logIn(email : String, password : String) : String
    // Получить информацию о пользователе
    fun getInfo(token : String) : InfoEntity
}