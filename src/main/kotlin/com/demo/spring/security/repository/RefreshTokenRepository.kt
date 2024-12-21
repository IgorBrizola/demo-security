package com.demo.spring.security.repository

import com.demo.spring.security.model.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RefreshTokenRepository: JpaRepository<RefreshToken, Int> {

    @Query("SELECT r.username FROM RefreshToken r WHERE r.token = ?1")
    fun findUsernameByToken(token: String): String?

    fun findByUsername(username: String): RefreshToken?
}