package com.example.task.data.repository

import com.example.task.data.source.dao.UserDao
import com.example.task.domain.model.User
import com.example.task.domain.repository.UserRepository
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//Temporary  User Repository to make changes
class UserRepositoryImpl @Inject constructor(private val dao: UserDao) : UserRepository{
    override suspend fun insertUser(user: User) {
        dao.insertUser(user)
    }

    override suspend fun getUserById(id: Int): User? {
       return dao.getUserById(id)
    }

    override fun getUsers(): Flow<List<User>> {
        return dao.getUsers()
    }
}