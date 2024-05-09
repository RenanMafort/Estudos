package com.sereia.renan.learningkotlin.fundamentos.collections

fun main() {
    //Listas imutaveis
    var listInt = listOf(2,1,2,3,6)
    val filter1 = listInt.filter { p -> p % 2 == 0 } //AMBOS FUNCIONAM
    val filter2 = listInt.filter { it % 2 == 0 }

    var listString = listOf("2","4","4","7","8")
    listString.filter { it.startsWith("4")}.first()
    println(filter1)
    println(filter2)

    listInt.forEach{ println(it) }

    println(listInt[1])
    println(listInt.get(2))
    println(listInt.indexOf(6))

    //lista mutaveis
    var listMutable = arrayListOf<Int>()
    listMutable.add(2)
    listMutable.add(4)

    println(listMutable)

    var listMutable2 = mutableListOf<Int>(1,2,6,4,3,7,6,8,44,66,22,11)
    listMutable2.sort()
    listMutable2.forEach{ println(it) }

    listMutable2.shuffle() // embaralha todos os elementos da lista


    var setOffList = setOf(1,2,2,4,4) //Não permite repetições

    var mapList = mutableMapOf("Renan" to 22,"Sereia" to 21) // "RENAN" -> CHAVE TO 22 É O VALOR
    mapList.put("Outro Nome", 49);

}