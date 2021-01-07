package com.example.kotlinloret.injection

import android.content.Context

import androidx.room.Room
import androidx.room.Room.databaseBuilder

import com.example.kotlinloret.data.Repository.UserRepository
import com.example.kotlinloret.data.local.models.AppDatabase
import com.example.kotlinloret.data.local.models.DatabaseDao
import com.example.kotlinloret.domain.usecase.CreateUserUseCase
import com.example.kotlinloret.domain.usecase.GetUserUseCase
import com.example.kotlinloret.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get(), get()) }
}

val domainModule = module {
    factory { CreateUserUseCase( get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = databaseBuilder(context,
        AppDatabase::class.java, "database-name"
    ).build()

    return appDatabase.databaseDao()
}
