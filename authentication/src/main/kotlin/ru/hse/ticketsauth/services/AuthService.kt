package ru.hse.ticketsauth.services

import ru.hse.ticketsauth.services.entities.InfoEntity

interface AuthService {
    // Создать пользователя
    fun createUser(userName : String, email : String, password : String)
    // Авторизовать пользователя
    fun authUser(email : String, password : String) : ru.hse.ticketsauth.services.entities.UserEntity
    // Получить информацию о пользователе по токену
    fun getInfo(token : String) : InfoEntity
}