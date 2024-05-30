package com.msinandemir.springboot_crud_with_kotlin.dtos.requests

data class UpdateBookRequest(
    val name: String,
    val description: String,
    val authorId: Long,
    val categoryId: Long
)
