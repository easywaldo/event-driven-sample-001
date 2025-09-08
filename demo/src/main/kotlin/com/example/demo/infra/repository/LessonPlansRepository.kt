package com.example.demo.infra.repository

import com.example.demo.infra.entity.LessonPlansEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface LessonPlansRepository: ReactiveCrudRepository<LessonPlansEntity, Long> {
    fun findByStudentId(studentId: Long): Flux<LessonPlansEntity>
}