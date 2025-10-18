package main

import "fmt"

func main() {
	var canal = make(chan string, 2)

	canal <- "Renan"
	canal <- "Mafort"
	canal <- "Sereia" //da deadlock, estou esperando 2 buffer e estou enviando 3 mensagem

	mensagem := <-canal
	mensagem2 := <-canal

	fmt.Println(mensagem)
	fmt.Println(mensagem2)

}
