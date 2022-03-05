package com.example.allRoutes

import com.example.models.orderStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.listOrderRoute() {
    route("/order"){
        // getting all orders
        get {
            if (orderStorage.isNotEmpty()){
                call.respond(orderStorage)
            }else{
                call.respondText("No orders found", status = HttpStatusCode.NotFound)
            }
        }
    }
}
fun Route.getOrderRoute(){
    route("/order/{id}"){
        get {
            val id = call.parameters["id"]?:
            return@get call.respondText("No order available", status = HttpStatusCode.NotFound)
            val order = orderStorage.find {
                    order -> order.number ==id }?: return@get call.respondText("No order for id ${id}", status = HttpStatusCode.NotFound)
            call.respond(order)

        }
    }
}

fun Route.getOrderTotalRoute(){
    route("/order/{id}/total"){
        get{
            val id = call.parameters["id"]?:
            return@get call.respondText("Not Found", status = HttpStatusCode.NotFound)

            val orderItem = orderStorage.find {
                    order -> order.number == id }?: return@get call.respondText("Not order for id $id", status = HttpStatusCode.NotFound)
            val total = orderItem.contents.sumOf { orderItems -> orderItems.amount * orderItems.price }
            call.respond(status = HttpStatusCode.OK, message = total)
        }
    }
}