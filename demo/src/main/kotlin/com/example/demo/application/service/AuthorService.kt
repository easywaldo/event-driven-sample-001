package com.example.demo.application.service

import com.example.demo.infra.entity.AuthorEntity
import com.example.demo.infra.port.`in`.dto.BookWithAuthorDto
import com.example.demo.infra.repository.AuthorRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono


@Service
class AuthorService(private val authorRepository: AuthorRepository) {
    fun createAuthor(author: BookWithAuthorDto): Mono<AuthorEntity> {
        val author = AuthorEntity(
            id = null,
            name = author.authorName
        )
        return authorRepository.save(author)
    }

    fun getAuthorById(id: Long): Mono<AuthorEntity?> {
        return authorRepository.findById(id)
    }
}