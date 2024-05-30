package com.msinandemir.springboot_crud_with_kotlin.services.concretes

import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.SaveBookRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.UpdateBookRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.GetBookResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.SaveBookResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.UpdateBookResponse
import com.msinandemir.springboot_crud_with_kotlin.entities.Author
import com.msinandemir.springboot_crud_with_kotlin.entities.Book
import com.msinandemir.springboot_crud_with_kotlin.repositories.BookRepository
import com.msinandemir.springboot_crud_with_kotlin.services.abstracts.AuthorService
import com.msinandemir.springboot_crud_with_kotlin.services.abstracts.BookService
import com.msinandemir.springboot_crud_with_kotlin.services.abstracts.CategoryService
import jakarta.persistence.EntityNotFoundException

class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val authorService: AuthorService,
    private val categoryService: CategoryService
) : BookService {

    override fun getBookById(bookId: Long): GetBookResponse {
        findBookById(bookId)
            .run {
                return GetBookResponse(id, name, description, author.id, category.id)
            }
    }

    override fun getAllBooks(): List<GetBookResponse> {
        return bookRepository.findAll().map {
            GetBookResponse(it.id, it.name, it.description, it.author.id, it.category.id)
        }
    }

    override fun saveBook(book: SaveBookRequest): SaveBookResponse {
        val foundAuthor = authorService.findAuthorById(book.authorId)
        val foundCategory = categoryService.findCategoryById(book.categoryId)
        val newBook = book.let {
            Book(0, it.name, it.description, foundAuthor, foundCategory)
        }
        return bookRepository.save(newBook)
            .run { SaveBookResponse(id, name, description, author.id, category.id) }
    }

    override fun updateBookById(bookId: Long, book: UpdateBookRequest): UpdateBookResponse {
        val foundBook = findBookById(bookId)
        val foundAuthor = authorService.findAuthorById(book.authorId)
        val foundCategory = categoryService.findCategoryById(book.categoryId)

        val updatedBook = foundBook.copy(name = book.name, description = book.description, author = foundAuthor, category = foundCategory)
        return bookRepository.save(updatedBook)
            .run {
                UpdateBookResponse(id,name,description,author.id,category.id)
            }
    }

    override fun deleteBookById(bookId: Long) {
        val foundBook = findBookById(bookId)
        bookRepository.deleteById(foundBook.id)
    }

    private fun findBookById(bookId: Long) = bookRepository.findById(bookId)
        .orElseThrow { EntityNotFoundException("Entity not found with id $bookId") }
}