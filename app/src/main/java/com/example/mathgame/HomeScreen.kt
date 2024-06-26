package com.example.mathgame

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.mathgame.navigation.Screens
import com.example.mathgame.shared.SharedPreference

@Composable
fun HomeScreen(navController: NavController) {
    Box {
        Image(painter = painterResource(id = R.drawable.mathh), contentDescription = "Main background", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PlayButton("Easy", 0, R.color.purple_200, navController)
            PlayButton("Medium", 1, R.color.teal_700, navController)
            PlayButton("Hard", 2, R.color.red50, navController)
            Spacer(modifier = Modifier.height(32.dp))
            val shared = SharedPreference.getInstance(LocalContext.current)
            val r1 = shared.getRecord(0)
            val r2 = shared.getRecord(1)
            val r3 = shared.getRecord(2)
            if (r1 > 0 || r2 > 0 || r3 > 0) Text(text = "Records", fontSize = 32.sp, fontWeight = FontWeight.SemiBold, color = colorResource(
                id = R.color.black
            ))
            if (r1 > 0) RecordText("Easy: $r1")
            if (r2 > 0) RecordText(text = "Medium: $r2")
            if (r3 > 0) RecordText(text = "Hard: $r3")
        }
    }
}

@Composable
fun RecordText(text: String) {
    Text(text = text, fontSize = 18.sp, color = Color.Black)
}

@Composable
fun PlayButton(text:String, levelId:Int, backColor:Int, navController: NavController) {
    Button(
        modifier = Modifier.padding(0.dp, 2.dp),
        border = BorderStroke(2.dp, colorResource(id = R.color.border_gray50)),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = backColor)),
        onClick = {
            navController.navigate(route = "game_screen/$levelId")
        }) {
        Text(text = text, color = colorResource(id = R.color.black), fontSize = 20.sp)
    }
}