package com.sereia.renan.learningkotlin.fundamentos.conditions.loops

fun main(){
    print1a10()
    print10a1()
    print1a10de2em2()
}

fun print1a10(){
    for (number in 1..10){
        print("$number ")
    }
    println()
}

fun print10a1(){
    for (number in 10 downTo 1){
        print("$number ")
    }
    println()
}

fun print1a10de2em2(){
    for (number in 1..10 step 10){
        print("$number ")
    }
}