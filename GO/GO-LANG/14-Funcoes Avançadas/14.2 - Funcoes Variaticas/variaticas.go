package main

import "fmt"

func calculosMatematicos(nums ...int) int {
	soma := 0
	for _, value := range nums {
		soma += value
	}

	return soma
}

func calculosMatematicos2(name string, nums ...int) (string, int) {
	soma := 0
	for _, value := range nums {
		soma += value
	}

	return name, soma
}

func main() {

	soma := calculosMatematicos(10, 20, 2, 1, 5, 7, 6, 4, 23)
	name, value := calculosMatematicos2("Renan", 10, 20, 2, 1, 5, 7, 6, 4, 23)
	fmt.Println(soma)
	fmt.Println(name, value)
}
