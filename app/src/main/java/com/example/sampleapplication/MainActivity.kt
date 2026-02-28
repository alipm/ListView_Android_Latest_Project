package com.example.sampleapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.*
import com.example.sampleapplication.ui.ProductViewModel
import com.example.sampleapplication.ui.screens.ProductDetailScreen
import com.example.sampleapplication.ui.screens.ProductListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            // Obtain ViewModel from Hilt
            val viewModel: ProductViewModel = hiltViewModel()
            NavHost(navController = navController, startDestination = "list") {
                // Route for List Screen
                composable("list") {
                    ProductListScreen(navController, viewModel)
                }

                // Route for Detail Screen with ID argument
                composable("details/{productId}") { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
                    val products by viewModel.products.collectAsState()
                    val product = products.find { it.id == id }

                    ProductDetailScreen(product)
                }
            }
        }
    }
}