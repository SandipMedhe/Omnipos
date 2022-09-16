package com.example.task.presentation.business_details

import com.example.task.presentation.login.AddEvent

sealed class BusinessDetailsEvent{
    data class EnterName(val value: String) : BusinessDetailsEvent()
    data class EnteredType(val value: String) : BusinessDetailsEvent()
    data class EnteredOwner(val value: String) : BusinessDetailsEvent()
    object InsertUser : BusinessDetailsEvent()
}
