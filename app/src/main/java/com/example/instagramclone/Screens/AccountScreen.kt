package com.example.instagramclone.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.instagramclone.api.posts
import com.example.instagramclone.api.users
import com.example.instagramclone.models.User
import com.example.instagramclone.ui.theme.OutlineButtonBackground
import com.example.instagramclone.widgets.History
import compose.icons.TablerIcons
import compose.icons.tablericons.*

@Composable
fun AccountScreen() {
    Scaffold(backgroundColor = Color.Black, topBar = {
        TopAppBar(backgroundColor = Color.Black) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = users[0].firstName,
                        color = Color.White,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(5.dp),
                    )
                    Icon(
                        TablerIcons.ChevronDown,
                        contentDescription = "ChevronDown icon",
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        TablerIcons.SquarePlus,
                        contentDescription = "Heart icon",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Icon(
                        TablerIcons.Menu2,
                        contentDescription = "Menu2 icon",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                }

            }
        }
    }) {
        Column(modifier = Modifier.fillMaxSize()) {
            BuildAccountHeader()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuildAccountHeader() {
    val user = users[0]

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp)
        ) {
            History(
                imgUrl = user.avatar,
                userName = user.firstName,
                alreadySeen = true,
                height = 80,
                width = 80,
                showUserName = true
            )
            Text(text = "49\nPosts", color = Color.White, fontSize = 13.sp)
            Text(text = "175\nFollowers", color = Color.White, fontSize = 13.sp)
            Text(text = "358\nFollowing", color = Color.White, fontSize = 13.sp)
            Spacer(modifier = Modifier.width(20.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CustomOutlineButton("Edit profile")
            Spacer(modifier = Modifier.width(5.dp))
            CustomOutlineButton("Share profile")
            Spacer(modifier = Modifier.width(5.dp))
            Card(
                modifier = Modifier
                    .height(35.dp)
                    .width(45.dp),
                backgroundColor = OutlineButtonBackground,
                shape = RoundedCornerShape(5.dp),
            ) {
                Icon(
                    imageVector = TablerIcons.UserPlus,
                    contentDescription = "UserPlus icon",
                    tint = Color.White,
                    modifier = Modifier
                        .width(15.dp)
                        .height(15.dp)
                        .padding(8.dp)
                )
            }
        }
        BuildPublications()
        LazyVerticalGrid(cells = GridCells.Fixed(3)) {
            items(posts.size) {
                val post = posts[it]
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
                        .width(250.dp)
                        .height(150.dp)
                        .padding(2.dp)
                )
            }
        }
    }
}

@Composable
fun CustomOutlineButton(text: String) {
    val screenWidth = LocalConfiguration.current.screenWidthDp

    OutlinedButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = OutlineButtonBackground
        ),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .height(35.dp)
            .width((screenWidth / 2.6).dp),
    ) {
        Text(text = text, color = Color.White)
    }
}

@Composable
fun BuildPublications() {
    val currentTab = 0
    val tabs = listOf(
        "Pubs" to TablerIcons.Table,
        "Photos" to TablerIcons.User,
    )
    TabRow(
        selectedTabIndex = 0,
        backgroundColor = Color.Black,
        indicator = {
            Box(
                Modifier
                    .tabIndicatorOffset(it[currentTab])
                    .height(1.dp)
                    .border(1.dp, Color.White)
            )
        }
    ) {
        tabs.forEachIndexed { index, _ ->
            val selected = index == currentTab
            Tab(
                selected = selected,
                onClick = { },
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Icon(
                    imageVector = tabs[index].second,
                    contentDescription = tabs[index].first,
                    tint = Color.White,
                    modifier = if (selected) Modifier.size(30.dp) else Modifier.size(33.dp)
                )
            }
        }
    }
}