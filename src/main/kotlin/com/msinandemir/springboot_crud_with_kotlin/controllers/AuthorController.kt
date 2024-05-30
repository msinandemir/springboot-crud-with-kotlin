package com.msinandemir.springboot_crud_with_kotlin.controllers

import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.SaveAuthorRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.UpdateAuthorRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.GetAuthorResponses
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.SaveAuthorResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.UpdateAuthorResponse
import com.msinandemir.springboot_crud_with_kotlin.services.abstracts.AuthorService
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
@RequestMapping("api/v1/authors")
class AuthorController(private val authorService: AuthorService) {

    @GetMapping("{authorId}")
    fun getAuthorById(@PathVariable authorId: Long): ResponseEntity<GetAuthorResponses> =
        ResponseEntity(authorService.getAuthorById(authorId), HttpStatus.OK)

    @GetMapping
    fun getAllAuthors(): ResponseEntity<List<GetAuthorResponses>> =
        ResponseEntity(authorService.getAllAuthors(), HttpStatus.OK)

    @PostMapping
    fun saveAuthor(@RequestBody author: SaveAuthorRequest): ResponseEntity<SaveAuthorResponse> =
        ResponseEntity(authorService.saveAuthor(author), HttpStatus.CREATED)

    @PutMapping("{authorId}")
    fun updateAuthorById(
        @PathVariable authorId: Long,
        @RequestBody author: UpdateAuthorRequest
    ): ResponseEntity<UpdateAuthorResponse> =
        ResponseEntity(authorService.updateAuthorById(authorId, author), HttpStatus.OK)

    @DeleteMapping("{authorId}")
    fun deleteAuthorById(@PathVariable authorId: Long) = authorService.deleteAuthorById(authorId)
}