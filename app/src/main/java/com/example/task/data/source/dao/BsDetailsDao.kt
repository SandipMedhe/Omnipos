package com.example.task.data.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.task.domain.model.BusinessDetails
import com.example.task.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface BsDetailsDao {
    @Query("SELECT * FROM  businessdetails")
    fun getBsDetails() : Flow<List<BusinessDetails>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBsDetails(businessdetails: BusinessDetails)
}