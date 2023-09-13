package com.example.instagramclone.widgets

import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.instagramclone.R
import com.example.instagramclone.ui.theme.*


@Composable
fun History(
    imgUrl: String,
    userName: String,
    alreadySeen: Boolean,
    width: Int = 90,
    height: Int = 90,
    showUserName: Boolean = false,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = modifier
                .padding(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .border(
                        brush = Brush.linearGradient(
                            if (alreadySeen) listOf(Color.Black, Color.Black) else listOf(
                                gradientColor3,
                                gradientColor3,
                                gradientColor2,
                                gradientColor1,
                            ),
                            start = Offset(0f, 270f),
                            end = Offset(150f, 2f),
                        ),
                        width = if (alreadySeen) 0.dp else 2.5.dp,
                        shape = CircleShape
                    )
            ) {
                SubcomposeAsyncImage(
                    model = imgUrl,
                    loading = {
                        CircularProgressIndicator()
                    },
                    contentDescription = "image of $userName",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(width.dp)
                        .height(height.dp)
                        .border(
                            width = if (alreadySeen) 0.dp else 24.dp,
                            color = Color.Black,
                            shape = CircleShape,
                        )
                        .clip(CircleShape)
                )
            }
        }
        if (showUserName) Text(text = userName, color = Color.White, fontSize = 11.sp)
    }
}