package ru.hse.ticketsauth.controllers

import org.springframework.web.bind.annotation.*
import ru.hse.ticketsauth.dao.AuthDao
import ru.hse.ticketsauth.dao.AuthDaoImpl
import ru.hse.ticketsauth.services.AuthService
import ru.hse.ticketsauth.services.TokenService

@RestController
class AuthControllerImpl (
    val authDao: AuthDao,
    val authService: AuthService,
    val tokenService: TokenService
) : AuthController {

    @PostMapping("/auth/create")
    override fun createUser(@RequestParam userName: String,
                            @RequestParam email: String,
                            @RequestParam password: String): String {
        authService.createUser(userName, email, password)
    }

    @GetMapping("/auth/login")
    override fun logIn(@RequestParam email: String,
                       @RequestParam password: String): String {
        val id = authService.authUser(email, password)
        val token = tokenService.getToken(id)
        return token
    }

    @GetMapping("/info/{token}")
    override fun getInfo(@PathVariable token: String): String {
        TODO("Not yet implemented")
    }
}