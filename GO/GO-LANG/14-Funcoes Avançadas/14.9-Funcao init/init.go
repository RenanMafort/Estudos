package main

import "fmt"

func alteracaoSemPonteiro(num int) int {
	return num * 2

}

func alteracaoComPonteiro(num *int) { //AQUI PASSAMOS O ENDEREÇO DE MEMORIA
	*num = 40

}

func main() {
	num := 10
	fmt.Println(num)

	fmt.Println(alteracaoSemPonteiro(num))
	fmt.Println(num)

	alteracaoComPonteiro(&num)
	fmt.Println(num)

	alteracaoComPonteiro(&num)
	fmt.Println(num)
}
