package main

import "fmt"

func main() {
	var variavel1 string = "Renan"
	variavel2 := "Renan Sereia"
	fmt.Println(variavel1, variavel2)

	var (
		variavel3 string = "variavel3"
		variavel4 string = "variavel4"
	)

	fmt.Println(variavel3, variavel4)

	variavel5, variavel6 := "variavel5", "variavel6"
	fmt.Println(variavel5, variavel6)

	variavel5, variavel6 = variavel6, variavel5 // INVERTE OS VALORES
	fmt.Println(variavel5, variavel6)

	const variavel7 string = "variavel7"
	
}
