package main

import (
	"fmt"
	"time"
)

func main() {
	var canal1, canal2 = make(chan string), make(chan string)

	go func() {
		for {
			canal1 <- "Olá mundo!"
			time.Sleep(time.Millisecond * 500)
		}
	}()

	go func() {
		for {
			canal2 <- "Hello world"
			time.Sleep(time.Second * 2)
		}
	}()

	//for {
	//	mensagem1 := <-canal1
	//	fmt.Println(mensagem1)
	//
	//	mensagem2 := <-canal2
	//	fmt.Println(mensagem2)
	//}

	for {
		select {
		case mensagem1 := <-canal1:
			fmt.Println(mensagem1)

		case mensagem2 := <-canal2:
			fmt.Println(mensagem2)

		}
	}

}
