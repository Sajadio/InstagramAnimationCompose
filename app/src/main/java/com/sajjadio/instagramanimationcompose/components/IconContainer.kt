package com.sajjadio.instagramanimationcompose.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sajjadio.instagramanimationcompose.ui.theme.PrimaryTextColor

@Composable
fun IconContainer(
    icon:Int,
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(
            id = icon,
        ),
        contentDescription = "",
        tint = PrimaryTextColor,
        modifier = modifier.padding(start = 16.dp)
    )
}