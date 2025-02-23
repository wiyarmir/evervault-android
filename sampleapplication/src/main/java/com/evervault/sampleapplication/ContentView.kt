package com.evervault.sampleapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentView(navController: NavController) {
    Scaffold { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            item {
                ListItem(
                    headlineText = { Text(text = "Basic Encryption") },
                    modifier = Modifier.clickable { navController.navigate("BasicEncryptionView") }
                )
            }
            item {
                ListItem(
                    headlineText = { Text(text = "File Encryption") },
                    modifier = Modifier.clickable { navController.navigate("FileEncryptionView") }
                )
            }
            item {
                ListItem(
                    headlineText = { Text(text = "Credit Card Inputs", style = MaterialTheme.typography.headlineSmall) },
                )
                ListItem(
                    headlineText = { Text(text = "Inline (Default)") },
                    modifier = Modifier.clickable { navController.navigate("CreditCardInputView") }
                )
                ListItem(
                    headlineText = { Text(text = "Inline Customized") },
                    modifier = Modifier.clickable { navController.navigate("CreditCardInputViewCustom") }
                )
                ListItem(
                    headlineText = { Text(text = "Rows") },
                    modifier = Modifier.clickable { navController.navigate("CreditCardInputViewRows") }
                )
                ListItem(
                    headlineText = { Text(text = "Custom Layout") },
                    modifier = Modifier.clickable { navController.navigate("CreditCardInputViewCustomStyle") }
                )
            }
            item {
                ListItem(
                    headlineText = { Text(text = "Cages", style = MaterialTheme.typography.headlineSmall) },
                )
                ListItem(
                    headlineText = { Text(text = "Cage HTTP Request") },
                    modifier = Modifier.clickable { navController.navigate("CageView") }
                )
            }
        }
    }
}
