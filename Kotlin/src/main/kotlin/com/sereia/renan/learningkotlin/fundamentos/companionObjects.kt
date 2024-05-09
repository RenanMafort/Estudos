package com.sereia.renan.learningkotlin.fundamentos

class PrimeriaClasse (var nome: String, var sobreNome: String, var idade: Int){
    companion object{
        fun criarMinhaClasse(): PrimeriaClasse{
            return PrimeriaClasse("Renan", "Sereia",25)
        }

        fun criarApartirDaSegundaClasse(segundaClasse: SegundaClasse): PrimeriaClasse{
            return PrimeriaClasse(segundaClasse.nome, segundaClasse.sobreNome,segundaClasse.idade)
        }
    }

}

class SegundaClasse(var nome: String, var sobreNome: String, var idade: Int){
    fun criarMinhaClasse(): SegundaClasse{
        return SegundaClasse("Renan", "Sereia",25)
    }
}

fun main() {
    var classe1 = PrimeriaClasse.criarMinhaClasse() // é como se fosse o static em java
    var classe3 = SegundaClasse("Renan", "Sereia",25).criarMinhaClasse();
    var classe2 = PrimeriaClasse.criarApartirDaSegundaClasse(classe3) // é como se fosse o static em java
}