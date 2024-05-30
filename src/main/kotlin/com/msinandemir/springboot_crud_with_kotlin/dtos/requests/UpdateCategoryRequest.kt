package com.msinandemir.springboot_crud_with_kotlin.dtos.requests

data class UpdateCategoryRequest(
    val name: String,
    val slug: String
)
