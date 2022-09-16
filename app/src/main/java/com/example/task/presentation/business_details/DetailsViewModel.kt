package com.example.task.presentation.business_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.domain.model.BusinessDetails
import com.example.task.domain.use_cases.GetBusinessDetails
import com.example.task.domain.use_cases.InsertBusinessDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val insertDetails: InsertBusinessDetails,
    private val getBusinessDetails: GetBusinessDetails
) : ViewModel() {

    private val _businessName = mutableStateOf(DetailsTextFieldState())
    val businessName: State<DetailsTextFieldState> = _businessName

    private val _businessType = mutableStateOf(DetailsTextFieldState())
    val businessType: State<DetailsTextFieldState> = _businessType

    private val _businessOwner = mutableStateOf(DetailsTextFieldState())
    val businessOwner: State<DetailsTextFieldState> = _businessOwner

    private var currentUserId: Int? = null

    fun onEvent(event: BusinessDetailsEvent) {
        when (event) {
            is BusinessDetailsEvent.EnterName -> {
                _businessName.value = businessName.value.copy(
                    text = event.value
                )
            }

            is BusinessDetailsEvent.EnteredType -> {
                _businessType.value = businessType.value.copy(
                    text = event.value
                )
            }

            is BusinessDetailsEvent.EnteredOwner -> {
                _businessOwner.value = businessOwner.value.copy(
                    text = event.value
                )
            }

            is BusinessDetailsEvent.InsertUser -> {
                viewModelScope.launch {
                    insertDetails(
                        BusinessDetails(
                            id = currentUserId,
                            name = businessName.value.text,
                            type = businessType.value.text,
                            owner = businessOwner.value.text
                        )
                    )
                }
                getData()
            }
        }
    }

    private fun getData() {

        viewModelScope.launch {
            kotlin.runCatching {
                getBusinessDetails().collect() {
                    println(it)

                }
            }
        }
    }
}