package com.example.task.domain.use_cases

import com.example.task.domain.model.BusinessDetails
import com.example.task.domain.repository.BusinessDetailsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBusinessDetails @Inject constructor(private val repository: BusinessDetailsRepository){
    operator fun invoke(): Flow<List<BusinessDetails>> {
        return repository.getBsDetails()
    }
}