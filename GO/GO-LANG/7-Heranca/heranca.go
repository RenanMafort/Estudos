package main

import "fmt"

type pessoa struct {
	nome      string
	sobrenome string
	idade     uint8
	altura    uint8
}

type estudante struct {
	pessoa
	curso string
}

func main() {

	var estudante1 estudante
	estudante1.nome = "Renan"
	estudante1.sobrenome = "Sereia"
	estudante1.idade = 20
	estudante1.altura = 181
	estudante1.curso = "Informatica"

	fmt.Println(estudante1)
	fmt.Println(estudante1.pessoa.nome) // assim funciona mas não precisa
	fmt.Println(estudante1.altura)

}
