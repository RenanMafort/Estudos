package main

import "fmt"

func main() {

	name := func(name string) string {
		return name
	}("Renan Sereia")

	fmt.Println(name)

}
