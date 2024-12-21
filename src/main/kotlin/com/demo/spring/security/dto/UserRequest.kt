package com.demo.spring.security.dto

data class UserRequest(
    val name: String,
    val email: String,
    val password: String,
)