package com.sajjadio.instagramanimationcompose

import android.annotation.SuppressLint
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.smallTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.sajjadio.instagramanimationcompose.ui.theme.InstagramAnimationComposeTheme
import com.sajjadio.instagramanimationcompose.utils.posts
import com.sajjadio.instagramanimationcompose.utils.stories

@Composable
fun HomeScreen() {
    HomeContent()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeContent() {

    var imageUrl by remember { mutableStateOf("") }
    var isScaledImage by remember { mutableStateOf(false) }
    val translateImagePositionY by animateDpAsState(
        targetValue = if (isScaledImage) 20.dp else 80.dp,
        animationSpec = tween(delayMillis = 500)
    )
    // Scale image of post
    val scaleImages by animateFloatAsState(
        targetValue = if (isScaledImage) 1.4f else 0f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )
    // Scale of message icon
    val scaleMessageIcon by animateFloatAsState(
        targetValue = if (translateImagePositionY == 20.dp) 1.1f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy)

    )

    if (translateImagePositionY == 20.dp) {
        isScaledImage = false
    }

    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                colors = smallTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {
                    Text(
                        text = "Instagram",
                        style = TextStyle(
                            Color.White,
                            fontSize = 32.sp,
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                },
                actions = {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.like,
                        ),
                        contentDescription = "likes",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(24.dp))
                    Icon(
                        painter = painterResource(
                            id = R.drawable.message,
                        ),
                        contentDescription = "message",
                        tint = Color.White,
                        modifier = Modifier.scale(scaleMessageIcon)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            )
        }
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {

            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    items(stories) { story ->
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .border(
                                        1.dp,
                                        color = Color(0xFF616161),
                                        shape = RoundedCornerShape(100.dp)
                                    )
                                    .padding(4.dp)
                            ) {
                                Image(
                                    painter = rememberAsyncImagePainter(model = story.image),
                                    contentDescription = story.username,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(100.dp))
                                        .size(85.dp),
                                    contentScale = ContentScale.FillWidth
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = story.username,
                                style = TextStyle(
                                    color = Color.White,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                    }
                }
            }

            items(posts) { post ->
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    color = Color(0xFF616161),
                                    shape = RoundedCornerShape(100.dp)
                                )
                                .padding(4.dp)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(model = post.image),
                                contentDescription = post.username,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(100.dp))
                                    .size(32.dp),
                                contentScale = ContentScale.FillWidth
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = post.username,
                            style = TextStyle(
                                color = Color.White,
                                fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            painter = painterResource(
                                id = R.drawable.baseline_more_horiz_24,
                            ),
                            contentDescription = "more",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Image(
                        painter = rememberAsyncImagePainter(model = post.post),
                        contentDescription = post.username,
                        modifier = Modifier
                            .height(400.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillHeight
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {

                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(
                                id = R.drawable.like,
                            ),
                            contentDescription = "like",
                            tint = Color.White,
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(
                            painter = painterResource(
                                id = R.drawable.comment,
                            ),
                            contentDescription = "comment",
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Icon(
                            painter = painterResource(
                                id = R.drawable.share,
                            ),
                            contentDescription = "share",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                imageUrl = post.post
                                isScaledImage = !isScaledImage
                            }
                        )
                        Spacer(
                            modifier = Modifier
                                .width(8.dp)
                                .weight(1f)
                        )
                        Icon(
                            painter = painterResource(
                                id = R.drawable.bookmark,
                            ),
                            contentDescription = "save",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "${post.likes} likes",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        ),
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                    )
                    Row() {
                        Text(
                            text = post.username,
                            style = TextStyle(
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            ),
                            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                        )

                        Text(
                            text = post.description,
                            style = TextStyle(
                                color = Color.White,
                                fontWeight = FontWeight.Normal
                            ),
                            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                        )
                    }
                    Text(
                        text = "View all ${post.comments} comments",
                        style = TextStyle(
                            color = Color(0xFF8F8F8F),
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                    )
                    Row(
                        modifier = Modifier.padding(top = 16.dp, start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = "https://th.bing.com/th/id/OIP.SzixlF6Io24jCN67HHZulAHaLH?w=182&h=273&c=7&r=0&o=5&dpr=1.3&pid=1.7\""),
                            contentDescription = post.username,
                            modifier = Modifier
                                .clip(RoundedCornerShape(100.dp))
                                .size(24.dp),
                            contentScale = ContentScale.FillWidth
                        )
                        Text(
                            text = "Add a comment...",
                            style = TextStyle(
                                color = Color(0xFF8F8F8F),
                                fontWeight = FontWeight.Normal
                            ),
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    Text(
                        text = post.time,
                        style = TextStyle(
                            color = Color(0xFF8F8F8F),
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(top = 8.dp, start = 8.dp)
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (isScaledImage) {
                Image(
                    painter = rememberAsyncImagePainter(model = imageUrl),
                    contentDescription = "image",
                    modifier = Modifier
                        .absoluteOffset(x = 360.dp, y = translateImagePositionY)
                        .scale(scaleImages)
                        .size(32.dp)
                        .clip(RoundedCornerShape(8.dp))

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    InstagramAnimationComposeTheme {
        HomeScreen()
    }
}