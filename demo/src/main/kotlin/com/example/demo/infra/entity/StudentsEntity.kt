package com.example.demo.infra.entity

import org.springframework.data.relational.core.mapping.Table

@Table("students")
data class StudentsEntity (
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String,
)