package main

import "fmt"

func recursiva(num int) int {
	if num <= 1 {
		return num
	}

	soma := recursiva(num-2) + recursiva(num-1)
	return soma
}

func main() {

	for i := 0; i < 10; i++ {
		fmt.Println(recursiva(i))
	}
	//fmt.Println(recursiva(10))

}
