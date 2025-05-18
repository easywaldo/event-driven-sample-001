package com.example.demo.infra.repository


import com.example.demo.infra.entity.UserEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface UserRepository : ReactiveCrudRepository<UserEntity, Long>