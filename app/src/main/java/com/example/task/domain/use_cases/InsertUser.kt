package com.example.task.domain.use_cases

import com.example.task.domain.model.User
import com.example.task.domain.repository.UserRepository
import javax.inject.Inject

class InsertUser @Inject constructor(
    private val repository: UserRepository
){
    suspend operator fun invoke(user : User){
        repository.insertUser(user)
    }
}