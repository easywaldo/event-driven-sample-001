package com.example.demo.infra.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("user_entity") // 테이블 이름을 명시적으로 지정
data class UserEntity(
    @Id
    val id: Long? = null, // R2DBC에서는 nullable로 설정
    val name: String,
    val email: String
)