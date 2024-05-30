package com.msinandemir.springboot_crud_with_kotlin.dtos.responses

data class UpdateBookResponse(
    val id: Long,
    val name: String,
    val description: String,
    val authorId: Long,
    val categoryId: Long
)
