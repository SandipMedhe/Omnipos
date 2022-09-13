package com.example.task.domain.use_cases

import com.example.task.domain.model.User
import com.example.task.domain.repository.UserRepository
import javax.inject.Inject

class GetUser @Inject constructor(
    private val repository: UserRepository
){
    suspend operator fun invoke(id: Int) : User?{
        return repository.getUserById(id)
    }
}