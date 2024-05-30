package com.msinandemir.springboot_crud_with_kotlin.repositories

import com.msinandemir.springboot_crud_with_kotlin.entities.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {
}