package com.example.task.domain.repository

import com.example.task.domain.model.BusinessAddress
import com.example.task.domain.model.BusinessDetails
import kotlinx.coroutines.flow.Flow

interface BusinessDetailsRepository {

    suspend fun insertBsDetails(bsDetails: BusinessDetails)

    fun getBsDetails(): Flow<List<BusinessDetails>>


}