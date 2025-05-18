package com.example.demo.application.service

import com.example.demo.infra.entity.UserEntity
import com.example.demo.infra.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(private val userRepository: UserRepository) {

    fun saveUsers(users: Flux<UserEntity>): Flux<UserEntity> {
        return users.flatMap { userRepository.save(it) }
    }

    fun getUserById(id: Long): Mono<UserEntity> {
        return userRepository.findById(id)
    }

    fun getAllUsers(): Flux<UserEntity> {
        return userRepository.findAll()
    }
}