package com.example.task.domain.model

import androidx.room.Entity

@Entity
data class BusinessDetails(
    val name: String,
    val type: String,
    val owner: String
)
