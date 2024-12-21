package com.demo.spring.security.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    @Column(name = "name")
    val name: String,
    @Column(name = "email")
    val email: String,
    @Column(name = "password")
    val password: String,
    @Enumerated(value = EnumType.STRING)
    val role: Role = Role.USER,
    @Column(name = "active")
    val active: Boolean = true
)

enum class Role { USER, ADMIN }
