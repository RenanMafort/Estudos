package main

import "fmt"

func recuperar() {
	if r := recover(); r != nil {
		fmt.Println("A aplicação conseguiu recuperar")
	}
}

func isAproved(nota float32) bool {
	defer recuperar()
	fmt.Println("Calculando a media do aluno")

	media := (nota + nota) / 2

	if media > 6 {
		return true
	} else if media < 6 {
		return false
	}

	panic("A aplicação entrou em panico")
}

func main() {

	fmt.Println(isAproved(6))
}
