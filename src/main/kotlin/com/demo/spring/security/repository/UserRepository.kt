package com.demo.spring.security.repository

import com.demo.spring.security.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {

    fun findByEmail(email: String): User

}