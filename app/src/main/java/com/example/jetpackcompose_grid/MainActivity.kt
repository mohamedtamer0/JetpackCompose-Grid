package com.example.jetpackcompose_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.runtime.Composable
import androidx.navigation.NavType

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose_grid.response.SampleData
import com.example.jetpackcompose_grid.ui.theme.JetpackComposeGridTheme
import com.example.jetpackcompose_grid.view.SampleDataDetails
import com.example.jetpackcompose_grid.view.SampleGrid
import com.google.gson.Gson

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

    NavHost(
        navController = navHostController,
        startDestination = "sample_data"
    ) {
        composable("sample_data") {
            SampleGrid(navHostController)
        }
        composable("sample_grid_detail/{item}",
            arguments = listOf(
                navArgument("item") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            navBackStackEntry?.arguments?.getString("item")?.let { json ->
                val item = Gson().fromJson(json, SampleData::class.java)
                SampleDataDetails(data = item)
            }
        }
    }
}

