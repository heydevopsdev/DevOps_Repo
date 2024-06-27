package com.example.housemartapplication.model

data class Product(
    val id: Int,
    val vendor: Vendor,
    val productName: String,
    val productDescription: String,
    val category: Category,
    val hasVariations: Boolean,
    val unitPrice: Double,
    val stock: Int,
    val size: String,
    val notes: String,
    val status: Int,
    val variations: List<Any>,
    val images: List<Any>,
    val reviews: List<Any>,
    val createdAt: String,
    val updatedAt: String,
    val sku: String
)

data class Vendor(
    val id: Int,
    val vendorName: String,
    val logo: String,
    val shopName: String,
    val gstNumber: String,
    val phoneNumber: String,
    val createdAt: String,
    val updatedAt: String
)

data class Category(
    val id: Int,
    val categoryName: String?,
    val categoryDescription: String,
    val createdAt: String,
    val updatedAt: String
)
