package com.microservice.chapter2

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class Chapter2Application {
	@Bean
	@ConditionalOnExpression("#{'\${service.message.type}' eq 'simple'}")
	fun exampleService() : ServiceInterface = ExampleService()

	@Bean
	@ConditionalOnExpression("#{'\${service.message.type}' eq 'advance'}")
	fun advanceService() : ServiceInterface = AdvanceService()
}

//@Controller
//class FirstClass(val exampleService: ExampleService) {
//	@RequestMapping(value = arrayOf("/user/{name}"), method = arrayOf(RequestMethod.GET))
//	@ResponseBody
//	fun hello(@PathVariable name: String) = exampleService.getHello(name)
//}

@Controller
class FirstClass {

	@Autowired
	lateinit var service: ServiceInterface

	@RequestMapping(value = arrayOf("/user/{name}"), method = arrayOf(RequestMethod.GET))
	@ResponseBody
	fun hello(@PathVariable name: String) = service.getHello(name)
}

fun main(args: Array<String>) {
	runApplication<Chapter2Application>(*args)
}
