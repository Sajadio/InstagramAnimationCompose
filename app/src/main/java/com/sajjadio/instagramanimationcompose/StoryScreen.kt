package com.sajjadio.instagramanimationcompose

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.sajjadio.instagramanimationcompose.utils.viewers

@Composable
fun StoryScreen(
    navController: NavController
) {
    StoryContent()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun StoryContent() {

    var isSwiped by remember { mutableStateOf(false) }

    val translateFirstItemPositionY by animateDpAsState(
        targetValue = if (isSwiped) (-200.dp) else 0.dp,
    )

    val translateContentPositionY by animateDpAsState(
        targetValue = if (isSwiped) 200.dp else 0.dp,
    )

    val scaleXImage by animateFloatAsState(
        targetValue = if (isSwiped) 0.3f else 1f,
    )
    val scaleYImage by animateFloatAsState(
        targetValue = if (isSwiped) 0.8f else 1f,
    )

    val heightImage by animateFloatAsState(
        targetValue = if (isSwiped) 0.35f else 1f,
    )

    Scaffold(
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                title = {},
                actions = {
                    if (scaleXImage != 1f) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.like,
                            ),
                            contentDescription = "likes",
                            tint = Color.White,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(
                                id = R.drawable.comment,
                            ),
                            contentDescription = "likes",
                            tint = Color.White,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable { isSwiped = !isSwiped }
        ) {

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(24.dp)
//                    ,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Icon(
//                    painter = painterResource(
//                        id = R.drawable.like,
//                    ),
//                    contentDescription = "likes",
//                    tint = Color.White
//                )
//                Icon(
//                    painter = painterResource(
//                        id = R.drawable.comment,
//                    ),
//                    contentDescription = "likes",
//                    tint = Color.White
//                )
//            }

            Box(
                modifier = Modifier
                    .fillMaxHeight(heightImage)
                    .fillMaxWidth()
                    .absoluteOffset(y = translateFirstItemPositionY)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .absoluteOffset(y = translateContentPositionY)
                        .scale(scaleXImage, scaleYImage),
                    contentScale = ContentScale.FillBounds
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF1F1F1F))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.like,
                        ),
                        contentDescription = "likes",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(
                            id = R.drawable.comment,
                        ),
                        contentDescription = "likes",
                        tint = Color.White
                    )
                    Spacer(
                        modifier = Modifier
                            .width(16.dp)
                            .weight(1f)
                    )

                    Icon(
                        painter = painterResource(
                            id = R.drawable.like,
                        ),
                        contentDescription = "likes",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(
                            id = R.drawable.comment,
                        ),
                        contentDescription = "likes",
                        tint = Color.White
                    )
                }
                Text(
                    text = "Viewers",
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.padding(start = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn {
                    items(viewers) { viewer ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(model = viewer.image),
                                contentDescription = viewer.username,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(100.dp))
                                    .size(40.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = viewer.username,
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
                            Spacer(modifier = Modifier.width(16.dp))
                            Icon(
                                painter = painterResource(
                                    id = R.drawable.message,
                                ),
                                contentDescription = "more",
                                tint = Color.White
                            )
                        }
                    }
                }
            }

        }
    }


}