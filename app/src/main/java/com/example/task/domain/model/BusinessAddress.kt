package com.example.task.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessAddress(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
val city: String,
val pin:String,
val address_1 : String,
val address_2: String

)
