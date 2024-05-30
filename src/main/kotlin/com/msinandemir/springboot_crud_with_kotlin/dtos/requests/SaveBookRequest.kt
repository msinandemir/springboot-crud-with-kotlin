package com.msinandemir.springboot_crud_with_kotlin.dtos.requests

data class SaveBookRequest(
    val name: String,
    val description: String,
    val authorId: Long,
    val categoryId: Long
)
