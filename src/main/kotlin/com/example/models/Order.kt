package com.example.models
val orderStorage= mutableListOf(Order("123444", listOf(
    OrderItems("Unga",10,43.9),
    OrderItems("Baking powder", 8,30.6),
    OrderItems("Madazi",4,5.0))
),
    Order("256252", listOf(
        OrderItems("Samsung Phone", 2, 17000.0),
        OrderItems("Samsung Smart Tv", 3,45000.0),
        OrderItems("Solar Panel", 5, 99000.78)
    ))
)
data class  Order(val number:String, val contents: List<OrderItems>)
data class OrderItems(val item: String, val amount: Int, val price: Double)
