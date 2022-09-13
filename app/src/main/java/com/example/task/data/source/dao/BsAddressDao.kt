package com.example.task.data.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.task.domain.model.BusinessAddress
import com.example.task.domain.model.BusinessDetails
import com.example.task.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface BsAddressDao {
    @Query("SELECT * FROM  BusinessAddress")
    fun getBsAddressDao() : Flow<List<BusinessAddress>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBsAddress(businessAddress: BusinessAddress)
}