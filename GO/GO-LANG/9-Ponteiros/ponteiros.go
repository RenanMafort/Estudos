package main

import "fmt"

func main() {
	var num int = 10
	var num2 = num

	fmt.Println(num, num2)
	num2++
	fmt.Println(num, num2) // 10 11

	fmt.Println("_----------------------")
	//PONTEIROS É O ENDEREÇO DE MEMORIA

	var ponteiro = &num
	*ponteiro++
	*ponteiro++
	fmt.Println(num)

	var num3 = &num
	var valor int = 22
	var memoria = &valor

	fmt.Println(*num3)                                                // aqui eu pego o valor da variavel
	fmt.Println("Valor da memoria - ", &valor)                        // aqui eu pego o endereço de memoria da va
	fmt.Println("Valor da variavel que esta na memoria - ", *memoria) // aqui eu pego o endereço de memoria da va

	var endmemoria = 10
	fmt.Println(&endmemoria)

	var defaultValuePonteiro *int8
	fmt.Println(defaultValuePonteiro) //<nil> - NULL em java

}
