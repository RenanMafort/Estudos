package main

import (
	"fmt"
	"time"
)

func main() {

	go escrever("Olá mundo") // 'go' manda executar algo e não esperar terminar para executar o restante
	escrever("Hello world")
	go escrever("teste")
}

func escrever(texto string) {
	for {
		fmt.Println(texto)
		time.Sleep(time.Second)
	}
}
