package com.example.task.domain.use_cases

import com.example.task.domain.model.BusinessAddress
import com.example.task.domain.repository.BusinessAddressRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBusinessAddress @Inject constructor(private  val repository: BusinessAddressRepository) {
    operator fun invoke(): Flow<List<BusinessAddress>> {
        return repository.getBsAddress()
    }
}