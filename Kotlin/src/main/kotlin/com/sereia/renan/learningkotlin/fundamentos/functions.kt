package com.sereia.renan.learningkotlin.fundamentos

fun main(){
    println(retornoString("Renan"))
    println(retornaBoolean(2))


    println(dizOi("Renan Mafort Sereia",25))
    println(dizOi(returnMyName(),25))
    println(dizOi(returnMyName()))
    println(dizOi(idade = 25, nome = returnMyName())) // -> caso queria inverter a orden dos parametros
}

fun returnMyName(): String{
    return "Renan Sereia";
}

fun retornoString(value: String): String{
    return "Olá ${value}!"
}

fun retornaBoolean(value: Any?): Boolean{
    if (value is String){
        return true
    }else {
        return false
    }
}

fun dizOi(nome:Any, idade: Int = 22):String{
    return "Olá, ${nome}. você tem ${idade} anos."
}