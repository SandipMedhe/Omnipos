package com.example.task.presentation.login


import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.domain.model.User
import com.example.task.domain.use_cases.GetUsers
import com.example.task.domain.use_cases.InsertUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val getUser: GetUsers,
    private val insertUser: InsertUser,
) : ViewModel() {


    private val _userName = mutableStateOf(TextFieldState())
    val userName: State<TextFieldState> = _userName

    private val _passWord = mutableStateOf(TextFieldState())
    val passWord: State<TextFieldState> = _passWord

   /* private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()*/

    private var currentUserId: Int? = null


    fun onEvent(event: AddEvent) {
        when (event) {
            is AddEvent.EnterName -> {
                _userName.value = userName.value.copy(
                    text = event.value
                )
            }

            is AddEvent.EnteredPassword -> {
                _passWord.value = passWord.value.copy(
                    text = event.value
                )
            }

            is AddEvent.InsertUser -> {
                viewModelScope.launch {
                    insertUser(
                        User(
                            id = currentUserId,
                            name = userName.value.text,
                            password = passWord.value.text,
                        )
                    )
                   // _eventFlow.emit(UiEvent.SaveUser)
                }
            }
        }
    }

    init {
        viewModelScope.launch {
            getUser().onEach { user ->
                Log.d("UserData", "$user")
            }
        }
    }


}

/*
sealed class UiEvent {
    object SaveUser : UiEvent()
}*/
