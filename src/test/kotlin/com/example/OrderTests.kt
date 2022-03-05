package com.example

import com.example.plugins.configureRouting
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.assertEquals

@Suppress("DEPRECATION")
class OrderTests {

    @Test
    fun testGetOrder(){
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/order/123444").apply {
                assertEquals("""{"number":"123444","contents":[{"item":"Unga","amount":10,"price":43.9},{"item":"Baking powder","amount":8,"price":30.6},{"item":"Madazi","amount":4,"price":5.0}]}""", response.content)
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}