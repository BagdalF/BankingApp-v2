    package com.example.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bankingapp.components.Header
import com.example.bankingapp.components.NavBar
import com.example.bankingapp.ui.theme.BankingAppTheme

class BankingAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}

data class Route( val name: String, val route: String, val icon: ImageVector )

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    var selectedItem by remember { mutableIntStateOf(0) }
    var lastSelectedItem by remember { mutableIntStateOf(0) }
    val routes = listOf(
        Route("Profile", "profile/{id}", Icons.Filled.Person),
        Route("Bank Statement", "statement/{id}", Icons.Filled.Settings),
        Route("Transfer", "transfer/{id}", Icons.Filled.Info)
    )

    NavHost(navController = navController, startDestination = "profile/testes") {
        composable("login") {
            Header(
                title = "Login"
            )

            Scaffold(modifier = Modifier.fillMaxSize()) {
                innerPadding ->

                Column(modifier = Modifier.padding(innerPadding)) {
                    LoginScreen()
                }
            }
        }
        composable("profile/{id}") {
            backstackEntry ->
            val param = backstackEntry.arguments?.getString("id") ?: ""

            Scaffold(modifier = Modifier.fillMaxSize(),
                bottomBar =
                    {
                        NavigationBar(
                            containerColor = Color.White,
                            tonalElevation = 8.dp,
                            modifier = Modifier.height(100.dp)
                        ) {
                            routes.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    icon = { Icon(item.icon, contentDescription = null) },
                                    label = { Text(item.name) },
                                    selected = selectedItem == index,
                                    onClick = { navController.navigate(item.route); lastSelectedItem = selectedItem; selectedItem = index; },
                                    alwaysShowLabel = true,
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = Color.White,
                                        selectedTextColor = Color.DarkGray,
                                        unselectedIconColor = Color.DarkGray,
                                        unselectedTextColor = Color.DarkGray,
                                        indicatorColor = Color(0xFF1976D2)
                                    )
                                )
                            }
                        }
                    }
            ) {
                innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    Header(
                        title = routes[selectedItem].name,
                        onIconClick = { navController.popBackStack(); selectedItem = lastSelectedItem; }
                    )

                    EditProfileScreen()
                }
            }
        }
        composable("statement/{id}") {
            backstackEntry ->
            val param = backstackEntry.arguments?.getString("id") ?: ""

            Scaffold( modifier = Modifier.fillMaxSize(),
                bottomBar =
                    {
                        NavigationBar(
                            containerColor = Color.White,
                            tonalElevation = 8.dp,
                            modifier = Modifier.height(100.dp)
                        ) {
                            routes.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    icon = { Icon(item.icon, contentDescription = null) },
                                    label = { Text(item.name) },
                                    selected = selectedItem == index,
                                    onClick = { navController.navigate(item.route); lastSelectedItem = selectedItem; selectedItem = index; },
                                    alwaysShowLabel = true,
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = Color.White,
                                        selectedTextColor = Color.DarkGray,
                                        unselectedIconColor = Color.DarkGray,
                                        unselectedTextColor = Color.DarkGray,
                                        indicatorColor = Color(0xFF1976D2)
                                    )
                                )
                            }
                        }
                    }
            ) { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    Header(
                        title = routes[selectedItem].name,
                        onIconClick = { navController.popBackStack(); selectedItem = lastSelectedItem; }
                    )

                    StatementScreen()
                }
            }
        }
        composable("transfer/{id}") {
            backstackEntry ->
            val param = backstackEntry.arguments?.getString("id") ?: ""

            Scaffold(modifier = Modifier.fillMaxSize(),
                bottomBar =
                    {
                        NavigationBar(
                            containerColor = Color.White,
                            tonalElevation = 8.dp,
                            modifier = Modifier.height(100.dp)
                        ) {
                            routes.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    icon = { Icon(item.icon, contentDescription = null) },
                                    label = { Text(item.name) },
                                    selected = selectedItem == index,
                                    onClick = { navController.navigate(item.route); lastSelectedItem = selectedItem; selectedItem = index; },
                                    alwaysShowLabel = true,
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = Color.White,
                                        selectedTextColor = Color.DarkGray,
                                        unselectedIconColor = Color.DarkGray,
                                        unselectedTextColor = Color.DarkGray,
                                        indicatorColor = Color(0xFF1976D2)
                                    )
                                )
                            }
                        }
                    }
            ) { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    Header(
                        title = routes[selectedItem].name,
                        onIconClick = { navController.popBackStack(); selectedItem = lastSelectedItem; }
                    )

                    TransferScreen()
                }
            }
        }
    }
}