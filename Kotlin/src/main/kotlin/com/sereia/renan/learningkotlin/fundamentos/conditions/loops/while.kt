package com.sereia.renan.learningkotlin.fundamentos.conditions.loops

fun main(){
    whileMenorQue10()
    doWhileMenoQue10()
}

fun whileMenorQue10(){
    var x = 0
    while (x <= 10){
        println(x)
        x++
    }
}

fun doWhileMenoQue10(){
    var x = 0
    do {
        println(x)
        x++
    }while (x < 10)
}