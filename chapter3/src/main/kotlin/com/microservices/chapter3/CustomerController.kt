package com.microservices.chapter3

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {

    @Autowired
    lateinit var customers: ConcurrentHashMap<Int, Customer>

//    @RequestMapping(value = ["/customer"], method = arrayOf(RequestMethod.GET))
////    fun getCustomer() = "hello from a controller" //결과 : hello from a controller
////    fun getCustomer() = Customer(1, "Kotlin") //결과 : {"id":1, "name":"Kotlin"}
//    fun getCustomer() = customers[2] //결과 : {"id": 2,"name": "Spring"}

    //경로 변수 얻기
//    @RequestMapping(value = ["/customer/{id}"], method = arrayOf(RequestMethod.GET))
//    fun getCustomer(@PathVariable id: Int) = customers[id] //결과 : 요청 숫자에 맞는 객체 리턴

    //모든 객체 반환
//    @RequestMapping(value = ["/customers"], method = arrayOf(RequestMethod.GET))
//    fun getCustomer() = customers.map(Map.Entry<Int, Customer>::value)

    //필터를 통한 반환
    @RequestMapping(value = ["/customers"], method = arrayOf(RequestMethod.GET))
    fun getCustomer(@RequestParam(required = false, defaultValue = "") nameFilter: String) = customers.filter {
        it.value.name.contains(nameFilter)
    }.map(Map.Entry<Int, Customer>::value) //요청을 /customers?nameFilter=in 으로 할 때 key가 1, 2인 결과만 나옴
}