package com.example.sampleapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sampleapplication.ui.ProductViewModel

@Composable
fun ProductListScreen(
    navController: NavController,
    viewModel: ProductViewModel
) {
    val products by viewModel.products.collectAsState()

    Scaffold(
        topBar = { Text("Product Store", modifier = Modifier.padding(16.dp)) }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(products) { product ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            // Pass the ID to navigate to details
                            navController.navigate("details/${product.id}")
                        }
                ) {
                    Text(
                        text = product.title,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}