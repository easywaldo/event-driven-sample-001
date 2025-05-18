package com.example.demo.infra.port.`in`.web


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class HelloController {

    @GetMapping("/hello")
    fun sayHello(): Mono<String> {
        return Mono.just("Hello, Reactive World!")
    }
}