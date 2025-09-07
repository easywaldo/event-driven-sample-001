package com.example.demo.infra.repository

import com.example.demo.infra.entity.StudentsEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface StudentsRepository : ReactiveCrudRepository<StudentsEntity, Long> {
    fun findByName(name: String): Flux<StudentsEntity>
}