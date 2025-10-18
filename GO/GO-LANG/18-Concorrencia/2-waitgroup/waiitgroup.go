package main

import (
	"fmt"
	"sync"
	"time"
)

func main() {
	var waitGroup = sync.WaitGroup{}

	waitGroup.Add(2) // quantas goroutiness será executada

	go func() {
		escrever("Olá mundo!")
		waitGroup.Done() // decrementa a quantidade de group 'waitGroup.Add(2) - 1'
	}()

	go func() {
		escrever("Hello world!")
		waitGroup.Done()
	}()

	waitGroup.Wait() //esperar acabar a quantidade de go routines

	fmt.Println("Fim do programa")

}

func escrever(texto string) {
	for i := 0; i < 5; i++ {
		fmt.Println(texto)
		time.Sleep(time.Second)
	}
}
