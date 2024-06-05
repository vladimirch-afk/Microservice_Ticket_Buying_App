package ru.hse.ticketsauth.utils

interface Encryptor {
    fun encrypt(password : String) : String
}