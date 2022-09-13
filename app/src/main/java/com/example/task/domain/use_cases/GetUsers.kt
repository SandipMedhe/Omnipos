package com.example.task.domain.use_cases

import com.example.task.domain.model.User
import com.example.task.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsers @Inject constructor(
    private val repository: UserRepository
){
     operator fun invoke(): Flow<List<User>>{
        return repository.getUsers()
    }
}