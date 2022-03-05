package com.example.models


// create a  mutable list
val customerList = mutableListOf<Customer>()

@kotlinx.serialization.Serializable
data class Customer(val id: String, val firstName: String,val lastName: String, val maritalStatus: String)


