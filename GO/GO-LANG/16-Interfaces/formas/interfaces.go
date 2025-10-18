package main

import "fmt"

type usuario struct {
	nome  string
	idade uint8
}

func (u usuario) imprimir() {
	fmt.Printf("O usuario %s tem %d anos\n", u.nome, u.idade)
}

func (u *usuario) alterarIdade() {
	u.idade++
}

func (u usuario) maiorDeIdade() bool {
	return u.idade >= 18
}

func main() {

	usuario1 := usuario{nome: "Renan", idade: 11}
	fmt.Println(usuario1)
	usuario1.imprimir()
	fmt.Println(usuario1.maiorDeIdade())
	usuario2 := usuario{nome: "Renan Sereia", idade: 25}
	fmt.Println(usuario2)
	usuario2.imprimir()
	usuario2.alterarIdade()
	usuario2.imprimir()
	fmt.Println(usuario2.maiorDeIdade())
}
