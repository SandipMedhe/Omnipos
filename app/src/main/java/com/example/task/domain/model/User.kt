package com.example.task.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//User Model
@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String,
    val password: String
)
