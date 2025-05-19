package com.example.demo.infra.port.`in`.dto

data class BookWithAuthorDto (
    val bookId: Long?,
    val bookTitle: String,
    val authorId: Long,
    val authorName: String?,
)