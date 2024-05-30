package com.msinandemir.springboot_crud_with_kotlin.repositories

import com.msinandemir.springboot_crud_with_kotlin.entities.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long> {
}