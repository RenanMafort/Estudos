package com.sereia.renan.learningkotlin.fundamentos

enum class Color {
    RED,BLUE,YELLOW
}

fun main(){
    val color = Color.RED;

    val result = when(color){
        Color.RED -> "renan"
        Color.BLUE -> TODO()
        Color.YELLOW -> TODO()
    }

    print(result)
}