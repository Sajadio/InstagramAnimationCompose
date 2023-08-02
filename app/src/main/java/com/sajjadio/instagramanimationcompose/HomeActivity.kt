package com.sajjadio.instagramanimationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sajjadio.instagramanimationcompose.ui.theme.InstagramAnimationComposeTheme
import com.sajjadio.instagramanimationcompose.ui.theme.PrimaryColor
import com.sajjadio.instagramanimationcompose.utils.HOME_ROUTE
import com.sajjadio.instagramanimationcompose.utils.STORY_ROUTE

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ChangeStatusBarColor()
            InstagramAnimationComposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = HOME_ROUTE) {
                    composable(HOME_ROUTE) {
                        HomeScreen(
                            navController = navController
                        )
                    }
                    composable(STORY_ROUTE) {
                        StoryScreen()
                    }
                }
            }
        }
    }

    @Composable
    @Stable
    private fun ChangeStatusBarColor() {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(color = PrimaryColor)
        }
    }
}
