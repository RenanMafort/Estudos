package main

import "fmt"

func closure() func() {
	texto := "Testando metodo closure"

	funcao := func() {
		fmt.Println(texto)
	}

	return funcao

}

func main() {
	defer fmt.Println("Fim do metodo main") //DEFER ADIA A EXECUÇÃO DEIXANDO POR ULTIMO

	variavel := closure()

	variavel()
}
