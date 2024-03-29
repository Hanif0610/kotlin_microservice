package com.microservice.chapter2

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

//@Service
//class ExampleService : ServiceInterface {
//    override fun getHello(name: String) = "hello $name"
//}

//@Service
//class ExampleService : ServiceInterface {
//
//    @Value(value = "\${service.message.text}")
//    private lateinit var text: String
//
//    override fun getHello(name: String) = "$text $name"
//}

class ExampleService : ServiceInterface {

    @Value(value = "\${service.message.text}")
    private lateinit var text: String

    override fun getHello(name: String) = "$text $name"
}