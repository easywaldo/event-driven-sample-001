package com.example.demo.infra.port.`in`.web

import com.example.demo.application.service.BookService
import com.example.demo.infra.entity.BookEntity
import com.example.demo.infra.port.`in`.dto.BookWithAuthorDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.awt.print.Book


@RestController
@RequestMapping("/api/books")
class BookController(private val bookService: BookService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody book: BookWithAuthorDto): Mono<BookEntity> {
        // 요청 바디에서 authorId를 받아 Book 객체에 설정해야 합니다.
        // 요청 DTO를 별도로 사용하는 것이 더 좋습니다. 여기서는 간단히 Book 엔티티를 사용합니다.
        return bookService.createBook(book)
    }

    // 단일 책 조회 (Author 정보 포함)
    @GetMapping("/{id}")
    fun getBookWithAuthor(@PathVariable id: Long): Mono<BookWithAuthorDto?> {
        return bookService.getBookWithAuthor(id)
    }

    // 책 목록 조회 (커서 기반 페이지네이션) - Author 정보 포함
    @GetMapping
    fun getBooksWithAuthor(
        @RequestParam(value = "lastId", defaultValue = "0") lastId: Long?,  // 커서: 마지막 조회된 책의 ID
        @RequestParam(value = "limit", defaultValue = "10") limit: Int
    ): Flux<BookWithAuthorDto?> { // 페이지 크기
        return bookService.getBooksWithAuthorCursor(lastId, limit)
    }
}