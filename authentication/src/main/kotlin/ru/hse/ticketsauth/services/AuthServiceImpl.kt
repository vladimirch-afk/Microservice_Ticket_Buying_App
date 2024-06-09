package ru.hse.ticketsauth.services

import org.springframework.stereotype.Service
import ru.hse.ticketsauth.utils.Encryptor
import ru.hse.ticketsauth.dao.UserEntityDao
import ru.hse.ticketsauth.dao.entities.UserEntity
import ru.hse.ticketsauth.mapper.UserEntityMapper
import ru.hse.ticketsauth.services.entities.InfoEntity
import java.time.LocalDateTime

@Service
class AuthServiceImpl(
    val encryptor: Encryptor,
    val userEntityDao: UserEntityDao,
    val userEntityMapper: UserEntityMapper,
    val tokenService: TokenService,
) : AuthService {
    override fun createUser(userName: String, email: String, password: String) {
        checkName(userName)
        checkEmail(email)
        checkPassword(password)
        val user = UserEntity(
            null,
            userName,
            email,
            encryptor.encrypt(password),
            LocalDateTime.now())
        try {
            userEntityDao.save(user)
        } catch (e: Exception) {
            throw IllegalArgumentException("Bad arguments for user creation are passed or user already exists.")
        }
    }

    override fun authUser(email: String, password: String): ru.hse.ticketsauth.services.entities.UserEntity {
        val user = userEntityDao.getUserEntityByEmail(email).orElseThrow()
        if (user.password != encryptor.encrypt(password)) {
            throw RuntimeException("Wrong password.")
        }
        return userEntityMapper.userEntityDaoToUserEntityService(user)
    }

    override fun getInfo(token: String): InfoEntity {
        val session = tokenService.findSessionByToken(token)
        val id = session.userId
        val userDao = userEntityDao.findById(id).get()
        val userService = userEntityMapper.userEntityDaoToUserEntityService(userDao)
        return userEntityMapper.userEntityServiceToInfoEntity(userService)
    }

    private fun checkName(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("Name can not be blank.")
        }
    }

    private fun checkEmail(email: String) {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        if (email.isEmpty() || !email.matches(emailRegex.toRegex())) {
            throw IllegalArgumentException("Invalid email format.")
        }
    }

    private fun checkPassword(password: String) {
        val special = "[@#\$&%!~]+"

        if (password.length < 8) {
            throw IllegalArgumentException("Password must contain 8 symbols.")
        }

        if (!password.any { it.isUpperCase() } || !password.any { it.isLowerCase() }) {
            throw IllegalArgumentException("Password must contain both letter registers.")
        }

        if (!password.any {it.isDigit()}) {
            throw IllegalArgumentException("Password must contain at least one digit.")
        }

        if (!password.any { special.contains(it) }) {
            throw IllegalArgumentException("Password must contain at least one special character"
            + "@#$&%!~")
        }
    }
}