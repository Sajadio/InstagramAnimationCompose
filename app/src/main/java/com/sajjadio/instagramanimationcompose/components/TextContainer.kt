package com.sajjadio.instagramanimationcompose.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sajjadio.instagramanimationcompose.ui.theme.PrimaryTextColor

@Composable
fun TextContainer(
    text: String,
    overflow: TextOverflow = TextOverflow.Clip,
    color: Color = PrimaryTextColor,
    fontWeight: FontWeight = FontWeight.SemiBold,
    modifier: Modifier = Modifier.padding(start = 16.dp, top = 8.dp)
) {
    Text(
        text = text,
        style = TextStyle(
            color = color,
            fontWeight = fontWeight,
        ),
        overflow = overflow,
        modifier = modifier,
        maxLines = 1
    )
}