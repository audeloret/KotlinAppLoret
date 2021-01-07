package com.example.kotlinloret.domain.usecase

import com.example.kotlinloret.data.Repository.UserRepository
import com.example.kotlinloret.domain.entity.User


class CreateUserUseCase (

        private val userRepository: UserRepository
    ) {
        suspend fun invoke(user: User){
            userRepository.createUser(user)
        }
    }
