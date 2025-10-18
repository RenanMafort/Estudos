package main

import "fmt"

func isAproved(nota float32) bool {
	fmt.Println("Calculando a media do aluno")

	media := (nota + nota) / 2

	defer fmt.Println("Fim do calcular nota")
	if media > 6 {
		fmt.Println("Aluno aprovado")
		return true
	}
	fmt.Println("Aluno reprovado")
	return false

}

func main() {
	defer fmt.Println("Fim do metodo main") //DEFER ADIA A EXECUÇÃO DEIXANDO POR ULTIMO

	fmt.Println(isAproved(10))
}
