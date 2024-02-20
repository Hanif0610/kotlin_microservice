package com.microservices.chapter3

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {

    @Autowired
    lateinit var customers: ConcurrentHashMap<Int, Customer>

    @RequestMapping(value = ["/customer"], method = arrayOf(RequestMethod.GET))
//    fun getCustomer() = "hello from a controller" //결과 : hello from a controller
//    fun getCustomer() = Customer(1, "Kotlin") //결과 : {"id":1, "name":"Kotlin"}
    fun getCustomer() = customers[2] //결과 : {"id": 2,"name": "Spring"}
}