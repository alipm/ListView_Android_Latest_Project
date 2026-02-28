package com.example.sampleapplication.data.model

// Data Model
data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String // URL for the product image
)
