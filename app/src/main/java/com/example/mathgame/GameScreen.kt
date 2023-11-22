package com.example.mathgame

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

private var ans = ""

@Preview(showBackground = true)
@Composable
fun GameScreen(){


    var problem = GameLogic().show()

    Log.d("TAG", problem.question)

    var question by remember {
        mutableStateOf(problem.question)
    }

    var answer by remember {
        mutableStateOf(problem.answer)
    }

    var score by remember {
        mutableStateOf(0)
    }

    var btnEnabled by remember{
        mutableStateOf(true)
    }

    var openDialog by remember {
        mutableStateOf(false)
    }

    ans = answer


    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center,

        ){



        Text(text = question,
            fontSize = 40.sp)

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            contentAlignment = Alignment.TopStart
        ){
            Text(text = "Score: $score",
                fontSize = 20.sp,
                color = Color.Black,)
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            contentAlignment = Alignment.TopEnd
        ){
//            Text(text = "Lives: $lives",
//                fontSize = 20.sp,
//                color = Color.Black,)

        }


        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom) {

            Spacer(modifier = Modifier.height(50.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.Center) {
                Button(onClick = {

                 var p = GameLogic().show()
                    question = p.question
                    answer = p.answer

                },
                    modifier = Modifier.weight(1f),
                    enabled = btnEnabled) {
                    Text(text = "+",
                        fontSize = 25.sp)

                }
                Spacer(modifier = Modifier.width(50.dp))

                Button(onClick = {

                    var p = GameLogic().show()
                    question = p.question
                    answer = p.answer
                },
                    modifier = Modifier.weight(1f),
                    enabled = btnEnabled) {
                    Text(text = "-",
                        fontSize = 25.sp)

                }

            }

            Row(modifier = Modifier
                .padding(horizontal = 50.dp, vertical = 20.dp)) {
                Button(onClick = {

                    var p = GameLogic().show()
                    question = p.question
                    answer = p.answer },
                    modifier = Modifier.weight(1f),
                    enabled = btnEnabled) {
                    Text(text = "*",
                        fontSize = 25.sp)

                }
                Spacer(modifier = Modifier.width(50.dp))

                Button(onClick = {

                    var p = GameLogic().show()
                    question = p.question
                    answer = p.answer },
                    modifier = Modifier.weight(1f),
                    enabled = btnEnabled) {
                    Text(text = "/",
                        fontSize = 25.sp)

                }
            }
        }
    }




    //----------------------------------------------------------





    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                openDialog = false
            },
            title = {
                Text(text = "You lose!")
            },
            text = {
                Column() {

                    Text("Want to play again?")
                }
            },
            confirmButton =  {
                Button(
                    modifier = Modifier,
                    onClick = {
                        openDialog = false


                    }
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(
                    modifier = Modifier,
                    onClick = { openDialog = false }
                ) {
                    Text("Main menu")
                }
            }
        )
    }


    //-------------------------------------------------------------------


}