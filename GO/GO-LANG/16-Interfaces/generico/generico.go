package main

import "fmt"

func generica(interfaces interface{}) {
	fmt.Println(interfaces)
}

func generica2(interfaces ...interface{}) {
	fmt.Println(interfaces)
}

func generica3(interfaces ...any) { //is an alias for interface{}
	fmt.Println(interfaces)
}

func main() {
	generica(1)
	generica("sadas")
	generica(true)
	fmt.Println(123)
	generica2(true, 2, "teste")
	generica3(true, 2, "teste")
}
