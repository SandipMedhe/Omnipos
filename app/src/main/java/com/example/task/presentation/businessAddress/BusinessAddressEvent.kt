package com.example.task.presentation.businessAddress



 sealed class BusinessAddressEvent {
  data class EnterCity(val value : String) :BusinessAddressEvent()
  data class EnterPin(val value : String) :BusinessAddressEvent()
  data class EnteredAddressOne(val value : String):BusinessAddressEvent()
  data class EnteredAddressTwo(val value : String):BusinessAddressEvent()
  object InsertAddress : BusinessAddressEvent()
  object GetAllDAta : BusinessAddressEvent()

}



