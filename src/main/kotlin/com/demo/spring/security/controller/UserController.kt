package com.demo.spring.security.controller

import com.demo.spring.security.dto.UserRequest
import com.demo.spring.security.dto.UserResponse
import com.demo.spring.security.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("security-api/user")
class UserController(
    private val userService: UserService
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createNewUser(
        @RequestBody userRequest: UserRequest
    ) = userService.createUser(userRequest)

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun getUsers(): List<UserResponse> = userService.getAllUsers()
}