package com.example.task.data.repository

import com.example.task.data.source.dao.BsDetailsDao
import com.example.task.domain.model.BusinessDetails
import com.example.task.domain.repository.BusinessDetailsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BusinessDetailsRepositoryImpl @Inject constructor(private val dao: BsDetailsDao) :
    BusinessDetailsRepository {
    override suspend fun insertBsDetails(bsDetails: BusinessDetails) {
        dao.insertBsDetails(bsDetails)
    }

    override fun getBsDetails(): Flow<List<BusinessDetails>> {
        return dao.getBsDetails()
    }
}