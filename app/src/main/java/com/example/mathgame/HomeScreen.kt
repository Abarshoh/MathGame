package com.example.mathgame

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.mathgame.navigation.Screens

@Composable
fun HomeScreen(navController: NavController) {
    Box {
        Image(painter = painterResource(id = R.drawable.main_background), contentDescription = "Main background", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PlayButton("Easy", 0, R.color.green50, navController)
            PlayButton("Medium", 1, R.color.blue50, navController)
            PlayButton("Hard", 2, R.color.red50, navController)
        }
    }
}

@Composable
fun PlayButton(text:String, id:Int, backColor:Int, navController: NavController) {
    Button(
        modifier = Modifier.padding(0.dp, 2.dp),
        border = BorderStroke(2.dp, colorResource(id = R.color.border_gray50)),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = backColor)),
        onClick = {
            navController.navigate(Screens.Game.withArgs(id.toString()))
        }) {
        Text(text = text, color = colorResource(id = R.color.white), fontSize = 20.sp)
    }
}