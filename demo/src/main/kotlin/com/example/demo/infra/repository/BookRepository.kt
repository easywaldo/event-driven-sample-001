package com.example.demo.infra.repository

import com.example.demo.infra.entity.BookEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface BookRepository : ReactiveCrudRepository<BookEntity, Long> {
    fun findByIdGreaterThanOrderByIdAsc(
        lastId: Long?,
        limit: Int
    ): Flux<BookEntity>
}