package com.example.jetpackcomposedemo

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Task(navController: NavController? = null, item: String? = null) {
    val context = LocalContext.current
    Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Text(text = "Task Details $item")
        LazyColumn {
            var i = 0
            items((0..5).toList()) {
                TaskCard("Detail Item ${i++}")
            }
        }

    }
}