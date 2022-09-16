package com.example.task.domain.use_cases

import com.example.task.domain.model.BusinessDetails
import com.example.task.domain.model.User
import com.example.task.domain.repository.BusinessDetailsRepository
import javax.inject.Inject

class InsertBusinessDetails @Inject constructor(private val repository: BusinessDetailsRepository) {
    suspend operator fun invoke(businessDetails: BusinessDetails) {
        repository.insertBsDetails(businessDetails)
    }
}