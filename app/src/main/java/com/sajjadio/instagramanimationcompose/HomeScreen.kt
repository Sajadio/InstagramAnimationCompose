package com.sajjadio.instagramanimationcompose

import android.annotation.SuppressLint
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.sajjadio.instagramanimationcompose.components.IconContainer
import com.sajjadio.instagramanimationcompose.components.ImageContainer
import com.sajjadio.instagramanimationcompose.components.TextContainer
import com.sajjadio.instagramanimationcompose.ui.theme.BorderColor
import com.sajjadio.instagramanimationcompose.ui.theme.PrimaryTextColor
import com.sajjadio.instagramanimationcompose.ui.theme.SecondaryTextColor
import com.sajjadio.instagramanimationcompose.utils.STORY_ROUTE
import com.sajjadio.instagramanimationcompose.utils.posts
import com.sajjadio.instagramanimationcompose.utils.stories

@Composable
fun HomeScreen(
    navController: NavController
) {
    HomeContent {
        navController.navigate(STORY_ROUTE)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeContent(
    onClickYourStory: () -> Unit
) {

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
                            PrimaryTextColor,
                            fontSize = 32.sp,
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                },
                actions = {
                    IconContainer(icon = R.drawable.like)
                    Spacer(modifier = Modifier.width(24.dp))
                    IconContainer(
                        icon = R.drawable.message,
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                ) {
                    items(stories.size) { index ->
                        Spacer(modifier = Modifier.width(16.dp))
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .border(
                                        1.dp,
                                        color = BorderColor,
                                        shape = RoundedCornerShape(100.dp)
                                    )
                                    .padding(4.dp)
                            ) {
                                if (index == 0) {
                                    ImageContainer(
                                        painter = painterResource(id = R.drawable.me),
                                        modifier = Modifier.size(85.dp),
                                        onClickImage = onClickYourStory,
                                        contentScale = ContentScale.FillHeight
                                    )
                                } else {
                                    ImageContainer(
                                        painter = rememberAsyncImagePainter(model = stories[index].image),
                                        modifier = Modifier.size(85.dp),
                                        onClickImage = {},
                                        contentScale = ContentScale.FillHeight
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            TextContainer(text = stories[index].username)
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
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Box(
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    color = BorderColor,
                                    shape = RoundedCornerShape(100.dp)
                                )
                                .padding(4.dp)
                        ) {
                            ImageContainer(
                                painter = rememberAsyncImagePainter(model = post.image),
                                modifier = Modifier.size(32.dp),
                                onClickImage = {},
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        TextContainer(text = post.username, modifier = Modifier.weight(1f))
                        IconContainer(icon = R.drawable.more)
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

                        IconContainer(icon = R.drawable.like)
                        IconContainer(icon = R.drawable.comment)
                        IconContainer(icon = R.drawable.share,
                            modifier = Modifier.clickable {
                                imageUrl = post.post
                                isScaledImage = !isScaledImage
                            })
                        Spacer(
                            modifier = Modifier
                                .width(8.dp)
                                .weight(1f)
                        )
                        IconContainer(icon = R.drawable.save)
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                    TextContainer(
                        text = "${post.likes} likes",
                    )
                    Row() {
                        TextContainer(text = post.username)
                        TextContainer(
                            text = post.description,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(start = 4.dp, top = 8.dp),
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    TextContainer(
                        text = "View all ${post.comments} comments",
                        color = SecondaryTextColor,
                        fontWeight = FontWeight.Normal
                    )

                    Row(
                        modifier = Modifier.padding(top = 16.dp, start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ImageContainer(
                            painter = painterResource(id = R.drawable.me),
                            modifier = Modifier.size(24.dp),
                            onClickImage = {},
                        )
                        TextContainer(
                            text = "Add a comment...",
                            color = SecondaryTextColor,
                            fontWeight = FontWeight.Normal
                        )
                    }
                    TextContainer(
                        text = post.time,
                        color = SecondaryTextColor,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (isScaledImage) {
                ImageContainer(
                    painter = rememberAsyncImagePainter(model = imageUrl),
                    sizeShape = 8,
                    modifier = Modifier
                        .absoluteOffset(x = 360.dp, y = translateImagePositionY)
                        .scale(scaleImages)
                        .size(40.dp),
                    contentScale = ContentScale.FillBounds,
                    onClickImage = {},
                )
            }
        }
    }
}