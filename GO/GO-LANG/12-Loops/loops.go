package main

import (
	"fmt"
	"time"
)

func main() {

	//num := 0

	//for num < 10 { // Seria a mesma do WHILE
	//	fmt.Println("Incrementando num - ", num)
	//	num++
	//	time.Sleep(time.Second)
	//}
	//
	//for i := 0; i < 10; i++ {
	//	fmt.Println("Incrementando for i -", i)
	//	time.Sleep(time.Second)
	//}

	array := [5]string{"Posição 1", "Posição 2", "Posição 3", "Posição 4", "Posição 5"}

	for _, value := range array {
		fmt.Println(value)
	}

	for index, value := range "PALAVRA" {
		fmt.Println(index, string(value))
	}

	for {
		fmt.Println("LOOP INFINITO")
		time.Sleep(time.Second)
	}

}
