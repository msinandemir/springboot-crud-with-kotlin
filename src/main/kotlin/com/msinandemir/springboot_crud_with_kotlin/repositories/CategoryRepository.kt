package com.msinandemir.springboot_crud_with_kotlin.repositories

import com.msinandemir.springboot_crud_with_kotlin.entities.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Long> {
}