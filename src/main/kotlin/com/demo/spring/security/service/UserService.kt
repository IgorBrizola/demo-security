package com.demo.spring.security.service

import com.demo.spring.security.dto.UserRequest
import com.demo.spring.security.dto.UserResponse
import com.demo.spring.security.model.User
import com.demo.spring.security.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun createUser(
        userRequest: UserRequest
    ): UserResponse {
        val user = User(
            name = userRequest.name,
            email = userRequest.email,
            password = userRequest.password,
        )

        userRepository.save(user)

        val newUser = UserResponse(
            name = user.name,
            email = user.email,
            password = user.password,
            role = user.role,
        )

        return newUser
    }

   @Transactional(readOnly = true)
   fun getAllUsers(): List<UserResponse> = userRepository
       .findAll()
       .map { user -> UserResponse(
           name = user.name,
           email = user.email,
           password = user.password,
           role = user.role,
       ) }
}