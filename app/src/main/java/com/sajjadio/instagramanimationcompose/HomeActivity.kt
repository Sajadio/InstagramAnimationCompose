package com.sajjadio.instagramanimationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sajjadio.instagramanimationcompose.ui.theme.InstagramAnimationComposeTheme
import com.sajjadio.instagramanimationcompose.utils.HOME_ROUTE
import com.sajjadio.instagramanimationcompose.utils.STORY_ROUTE

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramAnimationComposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = HOME_ROUTE) {
                    composable(HOME_ROUTE) {
                        HomeScreen(
                            navController = navController
                        )
                    }
                    composable(STORY_ROUTE) {
                        StoryScreen(
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}
