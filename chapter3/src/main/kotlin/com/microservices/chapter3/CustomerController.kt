package com.microservices.chapter3

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {

    @RequestMapping(value = ["/customer"], method = arrayOf(RequestMethod.GET))
//    fun getCustomer() = "hello from a controller" //결과 : hello from a controller
    fun getCustomer() = Customer(1, "Kotlin") //결과 : {"id":1, "name":"Kotlin"}
}