package com.sajjadio.instagramanimationcompose.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun ImageContainer(
    painter: Painter,
    sizeShape: Int = 100,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.FillHeight,
    onClickImage: () -> Unit
) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
            .clip(RoundedCornerShape(sizeShape.dp))
            .clickable {
                onClickImage()
            },
        contentScale = contentScale
    )
}