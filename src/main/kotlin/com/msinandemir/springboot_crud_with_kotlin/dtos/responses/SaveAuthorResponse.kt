package com.msinandemir.springboot_crud_with_kotlin.dtos.responses

data class SaveAuthorResponse(
    val id: Long,
    val firstName: String,
    val lastName: String
)
