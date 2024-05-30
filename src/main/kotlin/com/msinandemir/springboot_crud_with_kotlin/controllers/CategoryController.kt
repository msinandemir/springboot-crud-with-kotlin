package com.msinandemir.springboot_crud_with_kotlin.controllers

import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.SaveCategoryRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.requests.UpdateCategoryRequest
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.GetCategoryResponses
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.SaveCategoryResponse
import com.msinandemir.springboot_crud_with_kotlin.dtos.responses.UpdateCategoryResponse
import com.msinandemir.springboot_crud_with_kotlin.services.abstracts.CategoryService
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
@RequestMapping("api/v1/categories")
class CategoryController(private val categoryService: CategoryService) {

    @GetMapping("{categoryId}")
    fun getCategoryById(@PathVariable categoryId: Long): ResponseEntity<GetCategoryResponses> =
        ResponseEntity(categoryService.getCategoryById(categoryId), HttpStatus.OK)

    @GetMapping
    fun getAllCategories(): ResponseEntity<List<GetCategoryResponses>> =
        ResponseEntity(categoryService.getAllCategories(), HttpStatus.OK)

    @PostMapping
    fun saveCategory(@RequestBody category: SaveCategoryRequest): ResponseEntity<SaveCategoryResponse> =
        ResponseEntity(categoryService.saveCategory(category), HttpStatus.CREATED)

    @PutMapping("{categoryId}")
    fun updateCategoryById(
        @PathVariable categoryId: Long, @RequestBody category: UpdateCategoryRequest
    ): ResponseEntity<UpdateCategoryResponse> =
        ResponseEntity(categoryService.updateCategoryById(categoryId, category), HttpStatus.OK)

    @DeleteMapping("{categoryId}")
    fun deleteCategoryById(@PathVariable categoryId: Long) = categoryService.deleteCategoryById(categoryId)
}