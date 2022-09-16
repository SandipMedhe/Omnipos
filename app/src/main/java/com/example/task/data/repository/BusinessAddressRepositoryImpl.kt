package com.example.task.data.repository

import com.example.task.data.source.dao.BsAddressDao
import com.example.task.data.source.dao.UserDao
import com.example.task.domain.model.BusinessAddress
import com.example.task.domain.repository.BusinessAddressRepository
import com.example.task.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BusinessAddressRepositoryImpl @Inject constructor(private val dao: BsAddressDao) : BusinessAddressRepository {
    override suspend fun insertBsAddress(bsAddress: BusinessAddress) {
        dao.insertBsAddress(bsAddress)
    }

    override fun getBsAddress(): Flow<List<BusinessAddress>> {
        return dao.getBsAddressDao()
    }
}