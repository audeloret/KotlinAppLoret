package com.example.kotlinloret.data.Repository


import com.example.kotlinloret.data.local.models.DatabaseDao
import com.example.kotlinloret.data.local.models.toData
import com.example.kotlinloret.domain.entity.User
import com.example.kotlinloret.data.local.models.toEntity


class UserRepository (

        private val databaseDao: DatabaseDao
    ) {

        suspend fun createUser(user: User){
            databaseDao.insert(user.toData())
        }

        fun getUser(email: String) : User? {
            val userLocal = databaseDao.findByName(email)
            return userLocal?.toEntity()
        }
    }


