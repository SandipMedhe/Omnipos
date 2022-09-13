package com.example.task.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.task.data.source.dao.BsAddressDao
import com.example.task.data.source.dao.BsDetailsDao
import com.example.task.data.source.dao.UserDao
import com.example.task.domain.model.BusinessAddress
import com.example.task.domain.model.BusinessDetails
import com.example.task.domain.model.User

//Database which created All tables which are included
@Database(entities = [User::class,BusinessAddress::class,BusinessDetails::class], version = 2)
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao : UserDao

    abstract val bsAddressDao: BsAddressDao

    abstract val bsDetailsDao: BsDetailsDao


}