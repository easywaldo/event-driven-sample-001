package com.example.demo.infra.port.`in`.web

import com.example.demo.application.service.UserService
import com.example.demo.infra.entity.UserEntity
import com.example.demo.infra.port.`in`.dto.UserDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class UserController(private val userService: UserService) {

    @PostMapping("/users")
    fun saveUsers(@RequestBody userDtos: Flux<UserDto>): Flux<UserEntity> {
        return userService.saveUsers(
            userDtos.map { dto ->
                UserEntity(name = dto.name, email = dto.email)
            }
        )
    }

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable id: Long): Mono<UserEntity> {
        return userService.getUserById(id)
    }

    @GetMapping("/users")
    fun getAllUsers(): Flux<UserEntity> {
        return userService.getAllUsers()
    }
}