package main

import (
	"fmt"
	"reflect"
)

func main() {

	var array1 [5]uint8
	array1[0] = 1
	array1[1] = 2
	array1[2] = 3
	fmt.Println(array1)

	array2 := [5]string{"Posição 1", "Posição 2", "Posição 3", "Posição 4", "Posição 5"}
	fmt.Println(array2)

	array3 := [...]uint8{1, 2, 3, 4}
	fmt.Println(array3)

	fmt.Println("--------------------------")
	var slice []uint
	slice = append(slice, 1)
	fmt.Println(slice)
	slice = append(slice, 8)
	fmt.Println(slice)

	fmt.Println(len(array2))

	slice3 := array2[1:3]
	fmt.Println(slice3)

	fmt.Println(reflect.TypeOf(slice3))

	array2[1] = "Posição alterada"
	fmt.Println(slice3)

	//Arrays Internos
	fmt.Println("--------------------------")
	slice4 := make([]float32, 10, 12)
	fmt.Println(len(slice4))
	fmt.Println(cap(slice4))

	slice4 = append(slice4, 22.00)
	fmt.Println(len(slice4))
	fmt.Println(cap(slice4))

	slice4 = append(slice4, 22.00)
	fmt.Println(len(slice4))
	fmt.Println(cap(slice4))

	slice4 = append(slice4, 22.00) // quanto atinge o limite maximo, o slice dobra o tamanho maximo
	fmt.Println(len(slice4))
	fmt.Println(cap(slice4))

	slice4[2] = 11.00
	fmt.Println(slice4)
}
