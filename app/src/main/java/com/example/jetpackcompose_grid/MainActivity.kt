package com.example.jetpackcompose_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose_grid.ui.theme.JetpackComposeGridTheme
import com.example.jetpackcompose_grid.view.SampleGrid

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeGridTheme {
                NavigatePage()
            }
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun NavigatePage() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "sample_data") {
        composable("sample_data") { SampleGrid(navController = navHostController) }
    }
}