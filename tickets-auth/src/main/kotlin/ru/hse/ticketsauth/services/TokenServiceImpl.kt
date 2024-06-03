package ru.hse.ticketsauth.services

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.stereotype.Service
import ru.hse.ticketsauth.dao.AuthDao
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TokenServiceImpl(
    val authDao : AuthDao
) : TokenService {

    private lateinit var secret: String

    override fun getToken(id: Int): String {
        val session = authDao.findById(id)

        val algo = Algorithm.HMAC256(secret)
        val expires = LocalDateTime.now().plusSeconds(lifetime)
        val token = JWT.create()
            .withIssuer(id.toString())
            .withExpiresAt(expires.toInstant(ZoneOffset.UTC))
            .sign(algo)

        authDao.save(SessionEntityDB(session?.id, userId, token, expires))
        return token
    }
}