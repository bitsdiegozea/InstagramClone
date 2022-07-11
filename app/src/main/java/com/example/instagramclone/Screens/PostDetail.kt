package com.example.instagramclone.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import compose.icons.TablerIcons
import compose.icons.tablericons.Send

@Composable
fun PostDetail(navController: NavHostController) {
    TopAppBar(
        backgroundColor = Color.Black,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "",
                    tint = Color.White, modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                )
                Text(
                    text = "Comments",
                    color = Color.White,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(start = 5.dp),
                )
            }
            Icon(imageVector = TablerIcons.Send, contentDescription = "", tint = Color.White)
        }

    }
}