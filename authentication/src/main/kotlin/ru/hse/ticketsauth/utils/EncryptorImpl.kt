package ru.hse.ticketsauth.utils

import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

@Component
class EncryptorImpl : Encryptor {
    override fun encrypt(password: String): String {
        val md: MessageDigest = MessageDigest.getInstance("SHA-512")
        val hashedPassword = md.digest(password.toByteArray(StandardCharsets.UTF_8))
        return String(hashedPassword)
    }
}