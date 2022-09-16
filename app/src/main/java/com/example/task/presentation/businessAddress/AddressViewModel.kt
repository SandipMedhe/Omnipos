package com.example.task.presentation.businessAddress

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.domain.model.BusinessAddress
import com.example.task.domain.model.BusinessDetails
import com.example.task.domain.use_cases.GetBusinessAddress
import com.example.task.domain.use_cases.InsertBusinessAddress
import com.example.task.presentation.business_details.BusinessDetailsEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(private val insertAddress : InsertBusinessAddress, private val getAddress: GetBusinessAddress) : ViewModel() {

    private val _addressCity = mutableStateOf(AddressTextFieldState())
    val addressCity: State<AddressTextFieldState> = _addressCity

    private val _addressPin = mutableStateOf(AddressTextFieldState())
    val addressPin: State<AddressTextFieldState> = _addressPin

    private val _addressDirectionOne = mutableStateOf(AddressTextFieldState())
    val addressDirectionOne: State<AddressTextFieldState> = _addressDirectionOne

    private val _addressDirectionTwo = mutableStateOf(AddressTextFieldState())
    val addressDirectionTwo: State<AddressTextFieldState> = _addressDirectionTwo

    private var currentUserId: Int? = null

    fun onEvent(event: BusinessAddressEvent) {
        when (event) {
            is BusinessAddressEvent.EnterCity -> {
                _addressCity.value = addressCity.value.copy(
                    text = event.value
                )
            }

            is BusinessAddressEvent.EnterPin -> {
                _addressPin.value = addressPin.value.copy(
                    text = event.value
                )
            }

            is BusinessAddressEvent.EnteredAddressOne -> {
                _addressDirectionOne.value = addressDirectionOne.value.copy(
                    text = event.value
                )
            }

            is BusinessAddressEvent.EnteredAddressTwo -> {
                _addressDirectionTwo.value = addressDirectionTwo.value.copy(
                    text = event.value
                )
            }
            /*  is BusinessAddressEvent.GetAllDAta ->{

                viewModelScope.launch {
                    getAddress().onEach {
                        Log.d("Data", "onEvent: $it")

                    }
                }
            }*/

            is BusinessAddressEvent.InsertAddress -> {
                viewModelScope.launch {
                    insertAddress(
                        BusinessAddress(
                            id = currentUserId,
                            city = addressCity.value.text,
                            pin = addressPin.value.text,
                            address_1 = addressCity.value.text,
                            address_2 = addressCity.value.text


                        )
                    )

                }
                getSa()

            }
        }
    }

        fun getSa() {

            viewModelScope.launch {
                kotlin.runCatching {
                    getAddress().collect() {
                        println(it)

                    }
                }
            }
        }


}