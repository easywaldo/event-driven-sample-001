package com.example.demo.application.service

import com.example.demo.infra.entity.AuthorEntity
import com.example.demo.infra.entity.BookEntity
import com.example.demo.infra.port.`in`.dto.BookWithAuthorDto
import com.example.demo.infra.repository.BookRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.function.Function


@Service
class BookService(
    private val bookRepository: BookRepository, // AuthorService 주입
    private val authorService: AuthorService
) {
    fun createBook(book: BookWithAuthorDto): Mono<BookEntity> {
        // Book 저장 전에 Author 존재 여부 확인 등의 로직 추가 가능
        val book = BookEntity(
            id = null,
            title = book.bookTitle,
            authorId = book.authorId
        )
        return bookRepository.save(book)
    }

    // Book 조회 (ID 기반) - Author 정보 포함
    fun getBookWithAuthor(bookId: Long): Mono<BookWithAuthorDto?> {
        return bookRepository.findById(bookId)
            .flatMap<BookWithAuthorDto?>(Function { book: BookEntity? ->
                authorService.getAuthorById(book!!.authorId!!)
                    .map(Function { author: AuthorEntity? ->
                        BookWithAuthorDto(
                            book.id!!,
                            book.title!!,
                            author!!.id!!,
                            author.name!!
                        )
                    })
                    .switchIfEmpty(
                        Mono.just<BookWithAuthorDto?>(
                            BookWithAuthorDto(
                                book.id!!,
                                book.title!!,
                                0L,
                                "Unknown Author"
                            )
                        )
                    )
            }) // Author가 없는 경우 처리
    }

    // Book 조회 (커서 기반 페이지네이션) - Author 정보 포함
    fun getBooksWithAuthorCursor(lastId: Long?, limit: Int): Flux<BookWithAuthorDto?> {
        return bookRepository.findByIdGreaterThanOrderByIdAsc(lastId, limit)
            .flatMap({ book ->
                authorService.getAuthorById(book.authorId!!)
                    .map(Function { author: AuthorEntity? ->
                        BookWithAuthorDto(
                            book.id!!,
                            book.title!!,
                            author!!.id!!,
                            author.name!!
                        )
                    })
                    .switchIfEmpty(
                        Mono.just<BookWithAuthorDto?>(
                            BookWithAuthorDto(
                                book.id!!,
                                book.title!!,
                                authorId = 0L,
                                authorName = ""
                            )
                        )
                    )
            })
    }
}