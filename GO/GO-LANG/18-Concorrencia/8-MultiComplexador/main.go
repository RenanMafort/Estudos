package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	canal := multiComplexador(escrever("Renan Sereia"), escrever("Mfortttt"))

	for i := 0; i < 10; i++ {
		fmt.Println(<-canal)
	}
}

func multiComplexador(mensagem1, mensagem2 <-chan string) <-chan string {
	canalSaida := make(chan string)

	go func() {
		for {
			select {
			case mensagem := <-mensagem1:
				canalSaida <- mensagem
			case mensagem := <-mensagem2:
				canalSaida <- mensagem
			}
		}
	}()

	return canalSaida
}

func escrever(texto string) <-chan string {
	var canal = make(chan string)

	go func() {
		for {
			canal <- fmt.Sprintf("Valor recebido: %s", texto)
			time.Sleep(time.Millisecond * time.Duration(rand.Intn(2000)))
		}
	}()

	return canal
}
