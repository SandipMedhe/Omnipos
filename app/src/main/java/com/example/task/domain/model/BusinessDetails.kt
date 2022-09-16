package com.example.task.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessDetails(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String,
    val type: String,
    val owner: String
)
