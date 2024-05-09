package com.sereia.renan.learningkotlin.fundamentos.conditions.loops

fun main(){
    val x = 70
     when(x){
         5, -5,6,7,8 -> println("cinco") //usado para executar uma unica função se os numeros forem um desses.
         in 5..11 -> println("Está entre 5 e 11") // é a mesma coisa que o de cima.
         !in 5..11 -> println("Não está entre 5 e 11")
         10 -> {      // podemos abrir um bloco para executar mais de uma operação
             println(1)
             println(2)
             println(3)
             println(4)
         }
         else -> println("FIM")

     }

    println(comecaComCinco("Renan "))
    when{
        comecaComCinco("Renan") -> println("Retornou true")
        comecaComCinco(2) -> println("Retornou false")
    }
}

fun comecaComCinco(x: Any): Boolean{
    return when(x){
        is String -> x.startsWith("ren".trim(),true)
        else -> false
    }
}