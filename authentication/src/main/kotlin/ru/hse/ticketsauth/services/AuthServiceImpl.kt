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
        val user = UserEntity(
            null,
            userName,
            email,
            encryptor.encrypt(password),
            LocalDateTime.now())
        userEntityDao.save(user)
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
}