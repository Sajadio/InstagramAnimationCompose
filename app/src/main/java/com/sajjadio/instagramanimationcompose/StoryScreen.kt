
package com.sajjadio.instagramanimationcompose

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.sajjadio.instagramanimationcompose.components.IconContainer
import com.sajjadio.instagramanimationcompose.components.ImageContainer
import com.sajjadio.instagramanimationcompose.components.TextContainer
import com.sajjadio.instagramanimationcompose.ui.theme.SecondaryColor

@Composable
fun StoryScreen() {
    StoryContent()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun StoryContent() {

    var isSwipedUp by remember { mutableStateOf(false) }

    val swipeProgress by animateFloatAsState(
        targetValue = if (isSwipedUp) 1f else 0f,
    )
    val scaleXStory by animateFloatAsState(
        targetValue = if (isSwipedUp) 0.5f else 1f,
    )
    val scaleYStory by animateFloatAsState(
        targetValue = if (isSwipedUp) 0.8f else 1f,
    )
    val containerHeightScale by animateFloatAsState(
        targetValue = if (isSwipedUp) 0.35f else 1f,
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
                    if (scaleXStory != 1f) {
                        IconContainer(
                            icon = R.drawable.setting,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        IconContainer(
                            icon = R.drawable.close,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .clickable {
                                    isSwipedUp = false
                                }
                        )
                    }
                }
            )
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxHeight(containerHeightScale)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = "https://pbs.twimg.com/media/F2e_I2YaAAAO_ty?format=jpg&name=900x900"),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .offset(y = swipeProgress.dp)
                        .scale(scaleXStory, scaleYStory)
                        .clickable {
                            isSwipedUp = false
                        }
                        .graphicsLayer(
                            translationY = swipeProgress
                        )
                        .pointerInput(Unit) {
                            detectTransformGestures { _, pan, _, _ ->
                                when {
                                    pan.y > 100f -> isSwipedUp = false
                                    pan.y <= -100f -> isSwipedUp = true
                                }
                            }
                        },
                    contentScale = ContentScale.Fit
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(SecondaryColor)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.eye,
                        ),
                        contentDescription = "eye",
                        tint = Color(0xFF347FFC)
                    )

                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "150",
                        style = TextStyle(Color(0xFF347FFC))
                    )
                    Spacer(
                        modifier = Modifier
                            .width(16.dp)
                            .weight(1f)
                    )

                    IconContainer(icon = R.drawable.delete)
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
                    items(com.sajjadio.instagramanimationcompose.utils.viewers) { viewer ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            ImageContainer(
                                painter = rememberAsyncImagePainter(model = viewer.image),
                                modifier = Modifier.size(40.dp),
                                onClickImage = {},
                                contentScale = ContentScale.FillHeight
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            TextContainer(
                                text = viewer.username,
                                modifier = Modifier.weight(1f)
                            )
                            IconContainer(icon = R.drawable.more)
                            Spacer(modifier = Modifier.width(16.dp))
                            IconContainer(icon = R.drawable.message)
                        }
                    }
                }
            }

        }
    }


}