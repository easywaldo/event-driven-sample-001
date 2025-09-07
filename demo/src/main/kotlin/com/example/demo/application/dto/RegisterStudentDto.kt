package com.example.demo.application.dto

import com.example.demo.infra.entity.StudentsEntity

data class RegisterStudentDto(
    val name: String,
    val email: String,
    val password: String,
)

fun RegisterStudentDto.toEntity() = StudentsEntity(
    id = null,
    name = this.name,
    email = this.email,
    password = this.password
)
