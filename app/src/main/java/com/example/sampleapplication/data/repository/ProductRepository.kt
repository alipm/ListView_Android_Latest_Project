package com.example.sampleapplication.data.repository

import com.example.sampleapplication.data.api.ApiService
import com.example.sampleapplication.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiService: ApiService // Injected from AppModule
) {
    fun getProducts(): Flow<List<Product>> = flow {
        emit(apiService.getProducts())
    }
}