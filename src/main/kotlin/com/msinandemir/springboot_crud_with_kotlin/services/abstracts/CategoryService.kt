package com.msinandemir.springboot_crud_with_kotlin.services.abstracts

import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.SaveCategoryRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.UpdateCategoryRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.GetCategoryResponses
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.SaveCategoryResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.UpdateCategoryResponse
import com.msinandemir.springboot_crud_with_kotlin.entities.Category

interface CategoryService {
    fun getCategoryById(categoryId: Long): GetCategoryResponses

    fun getAllCategories(): List<GetCategoryResponses>

    fun saveCategory(category: SaveCategoryRequest): SaveCategoryResponse

    fun updateCategoryById(categoryId: Long, category: UpdateCategoryRequest): UpdateCategoryResponse

    fun deleteCategoryById(categoryId: Long)

    fun findCategoryById(categoryId: Long): Category
}