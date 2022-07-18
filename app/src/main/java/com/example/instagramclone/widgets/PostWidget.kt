package com.example.instagramclone.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.example.instagramclone.models.Post
import compose.icons.TablerIcons
import compose.icons.tablericons.*
import org.intellij.lang.annotations.JdkConstants

@Composable
fun PostWidget(post: Post, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
            .shadow(elevation = 8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            buildHeader(post = post)
            buildImage(post = post)
            buildFooter(post = post, navController = navController)
        }

    }
}

@Composable
fun buildHeader(post: Post) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(modifier = Modifier.padding(3.dp)) {
                History(
                    imgUrl = post.user.avatar,
                    userName = post.title,
                    alreadySeen = post.user.alreadySeen,
                    width = 40,
                    height = 40,
                    showUserName = false
                )
            }
            Text(
                text = post.user.firstName,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Icon(
            Icons.Outlined.MoreVert,
            contentDescription = "More options icon",
            tint = Color.White
        )
    }
}

@Composable
fun buildImage(post: Post) {
    val configuration = LocalConfiguration.current
    val height = configuration.screenHeightDp * 0.6
    val width = configuration.screenWidthDp.dp

    SubcomposeAsyncImage(
        model = post.url,
        loading = {
            Box(
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
            ) {
                CircularProgressIndicator()
            }
        },
        contentDescription = "image of ${post.id}",
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
            .width(width)
            .height(height.dp)
    )
}


@Composable
fun buildFooter(post: Post, navController: NavHostController) {
    val text = remember { mutableStateOf("") }

    Column {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        if (post.like) Icons.Rounded.Favorite else TablerIcons.Heart,
                        contentDescription = "Heart icon",
                        tint = if (post.like) Color.Red else Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Icon(
                        TablerIcons.MessageCircle,
                        contentDescription = "MessageCircle icon",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Icon(
                        TablerIcons.Send,
                        contentDescription = "Send icon",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Icon(
                    TablerIcons.Bookmark,
                    contentDescription = "Bookmark icon",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = post.title, color = Color.White)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "23,297 Me gusta", color = Color.White)
            Text(
                text = "Ver los 389 comentarios",
                color = Color(0xff858585),
                modifier = Modifier.clickable {
                    navController.navigate("postDetail/${post.id}")
                })

            Row(verticalAlignment = Alignment.CenterVertically) {
                History(
                    imgUrl = post.user.avatar,
                    userName = post.user.firstName,
                    alreadySeen = true,
                    width = 40,
                    height = 40,
                    showUserName = false
                )
                TextField(
                    value = text.value,
                    onValueChange = { println(it) },
                    readOnly = true,
                    textStyle = TextStyle(color = Color.White),
                    placeholder = {
                        Text(
                            text = "Agrega un comentario...",
                            color = Color(0xff858585)
                        )
                    },
                    singleLine = true,
                    trailingIcon = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                Icons.Rounded.Favorite,
                                contentDescription = "Heart icon",
                                tint = Color.Red,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(text = "\uD83D\uDE4C", fontSize = 15.sp)
                            Spacer(modifier = Modifier.width(5.dp))
                            Icon(
                                TablerIcons.CirclePlus,
                                contentDescription = "CirclePlus icon",
                                tint = Color.White,
                                modifier = Modifier.size(13.dp)
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )
            }
        }
        Divider(color = Color(0xff292929), modifier = Modifier.fillMaxWidth(), thickness = 0.2.dp)
    }
}