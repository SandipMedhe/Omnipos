package com.example.task.domain.use_cases

import com.example.task.domain.model.BusinessAddress
import com.example.task.domain.repository.BusinessAddressRepository
import javax.inject.Inject

class InsertBusinessAddress @Inject constructor(private val repository: BusinessAddressRepository) {

    suspend operator fun invoke(businessAddress : BusinessAddress){
        repository.insertBsAddress(businessAddress)
    }
}