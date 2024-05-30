package com.msinandemir.springboot_crud_with_kotlin.services.abstracts

import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.SaveAuthorRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.UpdateAuthorRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.GetAuthorResponses
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.SaveAuthorResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.UpdateAuthorResponse
import com.msinandemir.springboot_crud_with_kotlin.entities.Author

interface AuthorService {
    fun getAuthorById(authorId: Long): GetAuthorResponses

    fun getAllAuthors(): List<GetAuthorResponses>

    fun saveAuthor(author: SaveAuthorRequest): SaveAuthorResponse

    fun updateAuthorById(authorId: Long, author: UpdateAuthorRequest): UpdateAuthorResponse

    fun deleteAuthorById(authorId: Long)

    fun findAuthorById(authorId: Long): Author
}