package com.example.jetpackcomposedemo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MainContent() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                Home(navController)
            }
            composable(
                "task?item={item}",
                arguments = listOf(navArgument("item")
                {
                    type = NavType.StringType
                    defaultValue = "item not available"
                })
            ) {
//                task/{item}/{item1}/{item2}
                val item = it.arguments?.getString("item")
                if (item != null) {
                    Task(item = item)
                }
            }
        }
    }

}

@Preview
@Composable
fun MainContentPreview() {
    MainContent()
}