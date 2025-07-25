package com.example.demo.infra.port.`in`.web

import com.example.demo.application.service.AuthorService
import com.example.demo.infra.entity.AuthorEntity
import com.example.demo.infra.port.`in`.dto.BookWithAuthorDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/api/authors")
class AuthorController(private val authorService: AuthorService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createAuthor(@RequestBody author: BookWithAuthorDto): Mono<AuthorEntity> {
        return authorService.createAuthor(author)
    }

    @GetMapping("/{id}")
    fun getAuthor(@PathVariable id: Long): Mono<AuthorEntity?> {
        return authorService.getAuthorById(id)
    }

    @GetMapping
    fun getAllAuthors(): Mono<List<AuthorEntity>> {
        return authorService.getAllAuthors()
    }
}