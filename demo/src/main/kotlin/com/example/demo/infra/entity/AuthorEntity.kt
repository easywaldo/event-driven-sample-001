package com.example.demo.infra.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Table("authors") // 데이터베이스 테이블명
data class AuthorEntity (
    @Id
    val id: Long? = null,
    val name: String? = null
)