package com.example.instagramclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instagramclone.Screens.HomeScreen
import com.example.instagramclone.Screens.PostDetail


@Composable
fun NavigationController(startDestination: String = "homeScreen") {
    val navController = rememberNavController()

    NavHost(navController, startDestination) {
        composable("homeScreen") { HomeScreen(navController) }
        composable("postDetail") { PostDetail(navController) }
    }
}

