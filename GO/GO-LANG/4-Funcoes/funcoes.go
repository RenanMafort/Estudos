package main

import (
	"fmt"
	"strconv"
)

func somar(n1 int8, n2 int8) string {

	res := n1 + n2
	return strconv.Itoa(int(res))
}

// (n1,n2 int8) as duas entradas será do tipo 'int8'
func returnMoreOneValues(n1, n2 int8) (int8, int8) {
	soma := n1 + n2
	subtracao := n1 - n2

	return soma, subtracao
}

func main() {

	fmt.Println(somar(10, 20))

	//Outros tipos de funções

	var f = func(txt string) string {
		fmt.Println(txt)
		return txt
	}

	result := f("Teste")

	fmt.Println(result)

	resultMoreOneValues1, _ := returnMoreOneValues(20, 40) // O '_' ignora o respectivo valor que seria retornado

	fmt.Println(resultMoreOneValues1)
}
