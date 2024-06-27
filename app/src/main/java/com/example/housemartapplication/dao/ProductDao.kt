package com.example.housemartapplication.dao

import com.example.housemartapplication.model.Product

interface ProductDao {
    fun addProduct(product: Product);
    fun removeProduct(product: Product);
    fun editProduct(product: Product);
}