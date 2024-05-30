package com.msinandemir.springboot_crud_with_kotlin.services.concretes

import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.SaveAuthorRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.UpdateAuthorRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.GetAuthorResponses
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.SaveAuthorResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.UpdateAuthorResponse
import com.msinandemir.springboot_crud_with_kotlin.entities.Author
import com.msinandemir.springboot_crud_with_kotlin.repositories.AuthorRepository
import com.msinandemir.springboot_crud_with_kotlin.services.abstracts.AuthorService
import jakarta.persistence.EntityNotFoundException

class AuthorServiceImpl(private val authorRepository: AuthorRepository) : AuthorService {
    override fun getAuthorById(authorId: Long): GetAuthorResponses {
        findAuthorById(authorId)
            .run { return GetAuthorResponses(id, firstName, lastName) }
    }

    override fun getAllAuthors(): List<GetAuthorResponses> {
        return authorRepository.findAll()
            .map { GetAuthorResponses(it.id, it.firstName, it.lastName) }
    }

    override fun saveAuthor(author: SaveAuthorRequest): SaveAuthorResponse {
        val newAuthor = author.let { Author(0, it.firstName, it.lastName, listOf()) }

        return authorRepository.save(newAuthor)
            .run { SaveAuthorResponse(id, firstName, lastName) }
    }

    override fun updateAuthorById(authorId: Long, author: UpdateAuthorRequest): UpdateAuthorResponse {
        val foundAuthor = findAuthorById(authorId)

        val updatedAuthor = foundAuthor.copy(firstName = author.firstName, lastName = author.lastName)
        return authorRepository.save(updatedAuthor)
            .run { UpdateAuthorResponse(id, firstName, lastName) }
    }

    override fun deleteAuthorById(authorId: Long) {
        val foundAuthor = findAuthorById(authorId)
        authorRepository.deleteById(foundAuthor.id)
    }

    override fun findAuthorById(authorId: Long): Author = authorRepository.findById(authorId)
        .orElseThrow { EntityNotFoundException("Entity not found with id $authorId") }
}