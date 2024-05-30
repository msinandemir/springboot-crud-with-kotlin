package com.msinandemir.springboot_crud_with_kotlin.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Table(name = "books")
@Entity
data class Book(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    val id: Long,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val description: String,

    @ManyToOne
    @JoinColumn(name = "author_id")
    val author: Author,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category
)


