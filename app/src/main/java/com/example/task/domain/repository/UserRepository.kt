package com.example.task.domain.repository

import com.example.task.domain.model.User
import kotlinx.coroutines.flow.Flow

//User repository
interface UserRepository {

    suspend fun insertUser(user: User)

    suspend fun getUserById(id: Int): User?

    fun getUsers(): Flow<List<User>>
}