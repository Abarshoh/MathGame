package com.example.mathgame

import com.example.mathgame.model.Problem

class GameLogic {

    var num1=0
    var num2=0
    var answer=0
    var operand=""
    var operands= arrayOf("+","-","*","/")




    private fun create(){

        num1=(1..9).random()
        num2=(1..9).random()
        operand=operands.random()

        when(operand){
            "+"-> answer=num1+num2
            "-"-> answer=num1-num2
            "*"-> answer=num1*num2
            "/"-> answer=num1/num2
        }

    }

    fun show(): Problem {
        create()
        return Problem((num1.toString()+operand+num2.toString()),answer.toString())
    }
}