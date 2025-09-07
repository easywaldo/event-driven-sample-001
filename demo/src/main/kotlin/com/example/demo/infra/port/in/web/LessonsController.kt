package com.example.demo.infra.port.`in`.web

import com.example.demo.application.dto.MakeLessonPlanDto
import com.example.demo.application.dto.RegisterStudentDto
import com.example.demo.domain.service.LessonService
import com.example.demo.infra.entity.LessonPlansEntity
import com.example.demo.infra.entity.StudentsEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/lessons")
class LessonsController(
    private val lessonService: LessonService,
) {
    @GetMapping("/students")
    fun getAllStudents(): Flux<StudentsEntity> {
        return lessonService.getAllStudents()
    }

    @PostMapping("/students")
    fun registerStudent(@RequestBody registerStudentDto: RegisterStudentDto): Mono<StudentsEntity> {
        return lessonService.registerStudent(registerStudentDto)
    }

    @PostMapping("/plans")
    fun makeLessonPlan(@RequestBody makeLessonPlan: MakeLessonPlanDto): Mono<LessonPlansEntity> {
        return lessonService.makeLessonPlan(makeLessonPlan)
    }

    @GetMapping("/plans")
    fun getAllLessonPlans(): Flux<LessonPlansEntity> {
        return lessonService.getAllLessonPlans()
    }
}