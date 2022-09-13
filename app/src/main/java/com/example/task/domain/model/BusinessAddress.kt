package com.example.task.domain.model

import androidx.room.Entity

@Entity
data class BusinessAddress(
val city: String,
val pin:Int,
val address_1 : String,
val address_2: String

)
