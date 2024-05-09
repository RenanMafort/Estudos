package com.sereia.renan.learningkotlin.fundamentos

class Pessoa(var nome: String, var idade: Int, var carro: Carro) {

    override fun toString(): String {
        return "Pessoa(nome='$nome', idade=$idade)"
    }
}

class Carro(var dono:String, var ano: String){
    lateinit var nome: String;

}

fun main(){
    var renan = Pessoa("Renan",22, Carro("Renan","1999"));
    println(renan)
    renan.idade = 25;
    println(renan.idade)
    println(renan.carro.dono)
    renan.carro.dono = renan.carro.dono.plus("Outro dono");
    println(renan.carro.dono)
    println(renan.carro.ano)
}