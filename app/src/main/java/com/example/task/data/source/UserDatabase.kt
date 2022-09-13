package com.example.task.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.task.data.source.dao.UserDao
import com.example.task.domain.model.User

//Database which created All tables which are included
@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao : UserDao
}