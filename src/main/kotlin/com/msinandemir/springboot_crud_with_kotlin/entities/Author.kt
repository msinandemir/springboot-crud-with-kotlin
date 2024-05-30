package com.msinandemir.springboot_crud_with_kotlin.entities

import jakarta.persistence.*

@Table(name = "authors")
@Entity
data class Author(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(nullable = false)
    val id: Long,

    @Column(nullable = false)
    val firstName: String,

    @Column(nullable = false)
    val lastName: String,

    @OneToMany(mappedBy = "author")
    val books:List<Book>
    )
