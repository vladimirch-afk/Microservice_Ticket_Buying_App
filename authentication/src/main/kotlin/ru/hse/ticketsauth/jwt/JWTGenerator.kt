package ru.hse.ticketsauth.jwt

import org.springframework.stereotype.Component
import java.util.Base64
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import javax.xml.crypto.dsig.SignatureMethod.HMAC_SHA256

@Component
class JWTGenerator: TokenGenerator {

    private val key : String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"

    // Сгенерировать JWT-токен
    override fun generateToken(payload: String): String {
        val header = b64("{\"alg\": \"HS256\", \"typ\": \"JWT\"}")
        val payl = b64(payload)
        val signature = hmac("$header.$payl")
        return "$header.$payl.$signature"
    }

    // Сгенерировать подпись для токена
    private fun hmac(string : String) : String {
        val secretKeySpec = SecretKeySpec(key.toByteArray(), HMAC_SHA256)
        val mac = Mac.getInstance("HmacSHA256")
        mac.init(secretKeySpec)
        return mac.doFinal(string.toByteArray()).joinToString("") { "%02x".format(it) }
    }

    // Закодировать с помощью Base64
    private fun b64(string : String) : String {
        return String(Base64.getEncoder().encode(string.toByteArray()))
    }
}