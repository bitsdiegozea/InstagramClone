package com.example.instagramclone.Screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.instagramclone.api.comments
import com.example.instagramclone.api.posts
import com.example.instagramclone.models.Post
import com.example.instagramclone.widgets.History
import com.halilibo.richtext.ui.RichText
import com.halilibo.richtext.ui.RichTextStyle
import compose.icons.TablerIcons
import compose.icons.tablericons.Send

@Composable
fun PostDetail(navController: NavHostController, postId: Int) {
    val post = posts.find { post -> postId.compareTo(post.id) == 0 }
    val allPosts = posts.toMutableList()
    allPosts.remove(post)

    Scaffold(topBar = {
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
    }, backgroundColor = Color.Black) {
        LazyColumn {
            item {
                buildComments(post = post!!, showCommentStats = false)
            }
            items(allPosts) {
                buildComments(post = it)
            }
        }
    }
}

@Composable
fun buildComments(post: Post, showCommentStats: Boolean = true) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        History(
            imgUrl = post.user.avatar,
            userName = post.user.firstName,
            alreadySeen = post.user.alreadySeen,
            width = 45,
            height = 45
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            RichText(style = RichTextStyle(paragraphSpacing = 1.sp)) {
                Text(
                    text = "${post.user.firstName} ",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(text = post.title, color = Color.White)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp)
            ) {
                Row() {
                    Text(
                        text = "28m",
                        color = Color(0xff858585),
                        fontSize = 13.sp
                    )
                    if (showCommentStats) {
                        Spacer(modifier = Modifier.width(25.dp))
                        Text(
                            text = "28 like",
                            color = Color(0xff858585),
                            fontSize = 13.sp
                        )
                        Spacer(modifier = Modifier.width(25.dp))
                        Text(
                            text = "send",
                            color = Color(0xff858585),
                            fontSize = 13.sp
                        )
                    }
                }

                if (showCommentStats) {
                    Icon(
                        if (post.like) Icons.Rounded.Favorite else Icons.Outlined.Favorite,
                        contentDescription = "Heart icon",
                        tint = if (post.like) Color.Red else Color(0xff858585),
                        modifier = Modifier.size(13.dp)
                    )
                }
            }
        }

    }
}
