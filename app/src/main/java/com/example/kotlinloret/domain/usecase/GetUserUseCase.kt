package com.example.kotlinloret.domain.usecase
import com.example.kotlinloret.data.Repository.UserRepository
import com.example.kotlinloret.domain.entity.User

class GetUserUseCase
    (
        private val userRepository: UserRepository
    ) {
        suspend fun invoke(email: String) : User? {
            return userRepository.getUser(email)
        }
    }
