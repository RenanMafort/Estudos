package com.sereia.renan.learningkotlin.fundamentos

fun main(){
//    var nome: String? = null
    var nome: String? = "Renan" // por padrão, String não pode receber 'null' a não ser que quisermos deixa-lá nulla com o "?"

    println(nome?.length) // O "?" é a mesma coisa que if(nome != null) ai chama o .length

//    val toShort: Short = nome!!.toShort() //'!!' garante que nome nunca será null


    //Elvis operator
    var nomeTwo: String? = null;

    var number: Int = nomeTwo?.length ?: 0 // O operador "?:" indica que se não cair na primeira operação, mostre a segunda no caso "0"
    var number2: Int = nomeTwo?.length ?:
    throw NullPointerException("UAUUUUU") // O operador "?:" indica que se não cair na primeira operação,lance a exceção

    println(number)

    var list1 : List<Int?> = listOf(1,2,null,3) // pode ter elementos nulos
    var list2 : List<Int?>? = null // a lista pode ser nula



}