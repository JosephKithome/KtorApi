package com.example.allRoutes

import com.example.models.Customer
import com.example.models.customerList
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.customerRoutes() {
    //get all customers
    route("/customer"){
        customerList.add(Customer("1234","Joseph","Kithome","Single"))
        customerList.add(Customer("1235","Jane","Jahmiel","Single"))


        get {
            if (customerList.isNotEmpty()){
                call.respond(customerList)
            }else{
                call.respondText("No customer found!", status = HttpStatusCode.NotFound)
            }
        }

        //get a customer with id
        get("{id}"){
            val id = call.parameters["id"]?: return@get call.respondText("Missing or malformed id")

            val customer = customerList.find { customer -> customer.id == id }?:
            return@get call.respondText("No customer found for id no $id", status = HttpStatusCode.NotFound)
            call.respond(customer)
        }

        //create a new customer
        post {
            val customer = call.receive<Customer>()
            customerList.add(customer)
            return@post call.respondText("Customer was added successfully", status = HttpStatusCode.Created)

        }

        //delete a customer
        delete("{id}"){
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.Accepted)

        }
    }
}