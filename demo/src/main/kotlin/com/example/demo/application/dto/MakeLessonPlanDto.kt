package com.example.demo.application.dto

import com.example.demo.infra.entity.LessonPlansEntity
import java.time.LocalDateTime
import java.time.ZoneOffset
import kotlin.jvm.java

data class MakeLessonPlanDto (
    val studentId: Long,
    val lessonStart: LocalDateTime,
    val lessonEnd: LocalDateTime,
)

fun MakeLessonPlanDto.toEntity() = LessonPlansEntity(
    id = null,
    studentId = this.studentId,
    lessonStart = this.lessonStart.atZone(java.time.ZoneId.of("Asia/Seoul")).toInstant(),
    lessonEnd = this.lessonEnd.atZone(java.time.ZoneId.of("Asia/Seoul")).toInstant(),
    status = "SCHEDULED"
)