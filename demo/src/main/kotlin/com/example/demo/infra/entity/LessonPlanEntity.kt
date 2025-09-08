package com.example.demo.infra.entity

import org.springframework.data.relational.core.mapping.Table
import java.time.Instant


@Table("lesson_plans")
data class LessonPlansEntity (
    val id: Long? = null,
    val studentId: Long? = null,
    val lessonStart: Instant,
    val lessonEnd: Instant,
    val status: String,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now()
)