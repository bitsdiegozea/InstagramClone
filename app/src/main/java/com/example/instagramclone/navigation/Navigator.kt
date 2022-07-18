package com.example.instagramclone.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.instagramclone.Screens.AccountScreen
import com.example.instagramclone.Screens.HomeScreen
import com.example.instagramclone.Screens.PostDetail
import com.example.instagramclone.api.posts


@Composable
fun NavigationController(startDestination: String = "homeScreen") {
    val navController = rememberNavController()

    NavHost(navController, startDestination) {
        composable("homeScreen") { HomeScreen(navController) }
        composable(
            "postDetail/{postId}",
            arguments = listOf(navArgument("postId") { type = NavType.IntType })
        ) { backStackEntry ->
            PostDetail(
                navController,
                postId = backStackEntry.arguments?.getInt("postId")!!
            )
        }
        composable("accountScreen") { AccountScreen() }
    }
}

