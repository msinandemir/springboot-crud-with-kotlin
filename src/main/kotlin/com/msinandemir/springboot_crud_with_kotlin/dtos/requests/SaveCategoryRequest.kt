package com.msinandemir.springboot_crud_with_kotlin.dtos.requests

data class SaveCategoryRequest(
    val name: String,
    val slug: String
)
