package com.example.sampleapplication.data.api

import com.example.sampleapplication.data.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

//Retrofit Instance
interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("products/{id}")
    suspend fun getProductDetails(@Path("id") id: Int): Product
}