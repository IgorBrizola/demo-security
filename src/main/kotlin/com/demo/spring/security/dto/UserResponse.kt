package com.demo.spring.security.dto

import com.demo.spring.security.model.Role

data class UserResponse(
    val name: String,
    val email: String,
    val password: String,
    val role: Role,
)