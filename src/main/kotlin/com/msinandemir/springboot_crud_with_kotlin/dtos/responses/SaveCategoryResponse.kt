package com.msinandemir.springboot_crud_with_kotlin.dtos.responses

data class SaveCategoryResponse(
    val id: Long,
    val name: String,
    val slug: String
)
