package com.sereia.renan.learningkotlin.fundamentos.conditions.loops

fun main() {
    println(parInpar(2))
    println(returnParInpar(3))
}

fun parInpar(numbe: Int): String {
    if (numbe % 2 == 0) {
        return "par";
    } else {
        return "impar"
    }
}

fun returnParInpar(numbe: Int): String {
    return if (numbe % 2 == 0) {
        "par";
    } else {
        "impar"
    }
}
