package com.example.task.domain.repository

import com.example.task.domain.model.BusinessAddress
import com.example.task.domain.model.User
import kotlinx.coroutines.flow.Flow

interface BusinessAddress {

    suspend fun insertBsAddress(bsAddress: BusinessAddress)

    fun getBsAddress(): Flow<List<BusinessAddress>>
}

