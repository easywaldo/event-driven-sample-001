package com.example.demo.domain.service

import com.example.demo.application.dto.MakeLessonPlanDto
import com.example.demo.application.dto.RegisterStudentDto
import com.example.demo.application.dto.toEntity
import com.example.demo.infra.entity.LessonPlansEntity
import com.example.demo.infra.entity.StudentsEntity
import com.example.demo.infra.repository.LessonPlansRepository
import com.example.demo.infra.repository.StudentsRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class LessonService (
    private val lessonRepository: LessonPlansRepository,
    private val studentsRepository: StudentsRepository,
) {
    fun registerStudent(registerStudentDto: RegisterStudentDto): Mono<StudentsEntity> {
        return studentsRepository.save(
            registerStudentDto.toEntity()
        )
    }

    fun getAllStudents(): Flux<StudentsEntity> {
        return studentsRepository.findAll()
    }

    fun makeLessonPlan(makeLessonPlan: MakeLessonPlanDto): Mono<LessonPlansEntity> {
        return lessonRepository.save(
            makeLessonPlan.toEntity()
        )
    }

    fun getAllLessonPlans(): Flux<LessonPlansEntity> {
        return lessonRepository.findAll()
    }
}