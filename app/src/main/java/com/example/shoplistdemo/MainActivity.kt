package com.example.shoplistdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import com.example.list_items.ListItemsScreen
import com.example.shoplistdemo.ui.theme.DemoItemsFromBdTheme
import com.example.list_items.components.TopBarBackgroundColor
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.statusBarColor = TopBarBackgroundColor.toArgb()
        window.navigationBarColor = TopBarBackgroundColor.toArgb()
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = true
            isAppearanceLightNavigationBars = true
        }
        setContent {
            DemoItemsFromBdTheme {
                ListItemsScreen()
            }
        }
    }
}