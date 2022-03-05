package com.example.plugins

import com.example.allRoutes.customerRoutes
import com.example.allRoutes.getOrderRoute
import com.example.allRoutes.getOrderTotalRoute
import com.example.allRoutes.listOrderRoute
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {

    routing {
      customerRoutes()
        listOrderRoute()
        getOrderRoute()
        getOrderTotalRoute()
    }
}
