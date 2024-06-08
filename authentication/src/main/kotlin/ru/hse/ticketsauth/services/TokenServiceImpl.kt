package ru.hse.ticketsauth.services

import org.springframework.stereotype.Service
import ru.hse.ticketsauth.dao.SessionEntityDao
import ru.hse.ticketsauth.dao.entities.SessionEntity
import ru.hse.ticketsauth.mapper.SessionEntityMapper
import ru.hse.ticketsauth.jwt.TokenGenerator
import java.time.LocalDateTime
import kotlin.jvm.optionals.getOrNull

@Service
class TokenServiceImpl(
    val sessionEntityDao: SessionEntityDao,
    val tokenGenerator : TokenGenerator,
    val sessionEntityMapper: SessionEntityMapper
) : TokenService {

    private val expirationTime : Long = 30

    override fun getTokenByUserId(id: Long): String {
        val session = sessionEntityDao.getByUserId(id)
        val expires = LocalDateTime.now().plusSeconds(expirationTime)
        val token = tokenGenerator.generateToken(id.toString())

        sessionEntityDao.save(SessionEntity(session.getOrNull()?.id, id, token, expires))
        return token
    }

    override fun findSessionByToken(token: String): ru.hse.ticketsauth.services.entities.SessionEntity {
        val session = sessionEntityDao.getByToken(token).orElseThrow()
        if(session.expireTime.isBefore(LocalDateTime.now())){
            throw IllegalStateException("Token is expired.")
        }
        return sessionEntityMapper.sessionEntityDaoToSessionEntityService(session)
    }

}