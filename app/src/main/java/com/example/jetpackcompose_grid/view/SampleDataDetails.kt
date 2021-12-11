package com.example.jetpackcompose_grid.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_grid.R
import com.example.jetpackcompose_grid.response.SampleData
import com.example.jetpackcompose_grid.ui.theme.Purple500

@Composable
fun SampleDataDetails(data: SampleData) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Purple500),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Grid Detail",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.padding(20.dp))

        Image(
            painterResource(R.drawable.icon),
            contentDescription = "Grid Image",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = data.name,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = data.desc,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}


