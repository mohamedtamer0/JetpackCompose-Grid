package com.example.jetpackcompose_grid.view

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.jetpackcompose_grid.response.SampleData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@Composable
fun SampleGrid(navController: NavController) {
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context,"SampleData.json")
    val gson = Gson()
    val gridSampleType = object :TypeToken<List<SampleData>>(){}.type
    val sampleData:List<SampleData> = gson.fromJson(dataFileString,gridSampleType)
}

fun getJsonDataFromAsset(context: Context, data:String) :String{
    return context.assets.open(data).bufferedReader().use { it.readText() }
}