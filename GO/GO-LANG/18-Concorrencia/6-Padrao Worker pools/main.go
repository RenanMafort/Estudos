package main

import "fmt"

func main() {
	var tarefas, resultados = make(chan int, 45), make(chan int, 45)

	go worker(tarefas, resultados)
	go worker(tarefas, resultados)
	go worker(tarefas, resultados)
	go worker(tarefas, resultados)
	go worker(tarefas, resultados)
	go worker(tarefas, resultados)
	go worker(tarefas, resultados)

	for i := 0; i < 45; i++ {
		tarefas <- i
	}
	close(tarefas)

	for i := 0; i < 45; i++ {
		fmt.Println(<-resultados)
	}
}

func worker(tarefas <-chan int, resultados chan<- int) {
	for numero := range tarefas {
		resultados <- recursiva(numero)
	}
}

func recursiva(num int) int {
	if num <= 1 {
		return num
	}

	soma := recursiva(num-2) + recursiva(num-1)
	return soma
}
