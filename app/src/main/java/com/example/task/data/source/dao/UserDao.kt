package com.example.task.data.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.task.domain.model.User
import kotlinx.coroutines.flow.Flow

//User Dao to access the data
@Dao
interface  UserDao {
    @Query("SELECT * FROM  user")
    fun getUsers() : Flow<List<User>>

    @Query("SELECT * FROM User WHERE id = :id")
    suspend fun getUserById(id: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
}