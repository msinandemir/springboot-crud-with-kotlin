package com.msinandemir.springboot_crud_with_kotlin.controllers

import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.SaveBookRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.UpdateBookRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.GetBookResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.SaveBookResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.UpdateBookResponse
import com.msinandemir.springboot_crud_with_kotlin.services.abstracts.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/books")
class BookController(private val bookService: BookService) {

    @GetMapping("{bookId}")
    fun getBookById(@PathVariable bookId: Long): ResponseEntity<GetBookResponse> =
        ResponseEntity(bookService.getBookById(bookId), HttpStatus.OK)

    @GetMapping
    fun getAllBooks(): ResponseEntity<List<GetBookResponse>> = ResponseEntity(bookService.getAllBooks(), HttpStatus.OK)

    @PostMapping
    fun saveBook(@RequestBody book: SaveBookRequest): ResponseEntity<SaveBookResponse> =
        ResponseEntity(bookService.saveBook(book), HttpStatus.CREATED)

    @PutMapping("{bookId}")
    fun updateBookById(
        @PathVariable bookId: Long, @RequestBody book: UpdateBookRequest
    ): ResponseEntity<UpdateBookResponse> = ResponseEntity(bookService.updateBookById(bookId, book), HttpStatus.OK)

    @DeleteMapping("{bookId}")
    fun deleteBookById(@PathVariable bookId: Long) = bookService.deleteBookById(bookId)
}