package com.msinandemir.springboot_crud_with_kotlin.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Table(name = "categories")
@Entity
data class Category(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val slug: String,

    @OneToMany(mappedBy = "category")
    val books: List<Book>
)
