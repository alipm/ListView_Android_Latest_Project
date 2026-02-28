package com.example.sampleapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sampleapplication.data.model.Product

@Composable
fun ProductDetailScreen(product: Product?) {
    if (product == null) {
        Text("Product not found")
        return
    }

    Column(modifier = Modifier.padding(16.dp)) {
        AsyncImage(
            model = product.image,
            contentDescription = product.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = product.title, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "$${product.price}", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = product.description, style = MaterialTheme.typography.bodyLarge)
    }
}