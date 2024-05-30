package com.msinandemir.springboot_crud_with_kotlin.services.abstracts

import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.SaveBookRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.UpdateBookRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.GetBookResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.SaveBookResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.UpdateBookResponse

interface BookService {
    fun getBookById(bookId: Long): GetBookResponse

    fun getAllBooks(): List<GetBookResponse>

    fun saveBook(book: SaveBookRequest): SaveBookResponse

    fun updateBookById(bookId: Long, book: UpdateBookRequest): UpdateBookResponse

    fun deleteBookById(bookId: Long)
}