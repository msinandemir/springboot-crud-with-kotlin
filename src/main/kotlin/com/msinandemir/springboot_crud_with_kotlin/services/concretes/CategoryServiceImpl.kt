package com.msinandemir.springboot_crud_with_kotlin.services.concretes

import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.SaveCategoryRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.UpdateCategoryRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.GetCategoryResponses
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.SaveCategoryResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.UpdateCategoryResponse
import com.msinandemir.springboot_crud_with_kotlin.entities.Category
import com.msinandemir.springboot_crud_with_kotlin.repositories.CategoryRepository
import com.msinandemir.springboot_crud_with_kotlin.services.abstracts.CategoryService
import jakarta.persistence.EntityNotFoundException

class CategoryServiceImpl(private val categoryRepository: CategoryRepository) : CategoryService {

    override fun getCategoryById(categoryId: Long): GetCategoryResponses {
        findCategoryById(categoryId)
            .run {
                return GetCategoryResponses(id, name, slug)
            }
    }

    override fun getAllCategories(): List<GetCategoryResponses> {
        return categoryRepository.findAll().map {
            GetCategoryResponses(it.id, it.name, it.slug)
        }
    }

    override fun saveCategory(category: SaveCategoryRequest): SaveCategoryResponse {
        val newCategory = category.let {
            Category(0, it.name, it.slug, listOf())
        }

        return categoryRepository.save(newCategory)
            .run { SaveCategoryResponse(id, name, slug) }
    }

    override fun updateCategoryById(categoryId: Long, category: UpdateCategoryRequest): UpdateCategoryResponse {
        val foundCategory = findCategoryById(categoryId)

        val updatedCategory = foundCategory.copy(name = category.name, slug = category.slug)
        return categoryRepository.save(updatedCategory)
            .run {
                UpdateCategoryResponse(id, name, slug)
            }
    }

    override fun deleteCategoryById(categoryId: Long) {
        val foundCategory = findCategoryById(categoryId)
        categoryRepository.deleteById(foundCategory.id)
    }

    override fun findCategoryById(categoryId: Long): Category = categoryRepository.findById(categoryId)
        .orElseThrow { EntityNotFoundException("Entity not found with id $categoryId") }

}