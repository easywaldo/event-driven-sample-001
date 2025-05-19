package com.example.demo.infra.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("books")
data class BookEntity (
    @Id
    val id: Long? = null,
    val title: String? = null,
    val authorId: Long? = null,
)