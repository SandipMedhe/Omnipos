package com.example.task.presentation.login

//classes to store the state of components
sealed class AddEvent {
    data class EnterName(val value: String) : AddEvent()
    data class EnteredPassword(val value: String) : AddEvent()
    object InsertUser : AddEvent()

}
