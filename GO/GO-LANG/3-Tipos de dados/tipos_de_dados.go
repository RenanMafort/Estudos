package main

import (
	"errors"
	"fmt"
)

func main() {
	//	Inteiros =int,int8,int16,int32,int64

	//int	Depends on platform:
	//32 bits in 32 bit systems and
	//64 bit in 64 bit systems	-2147483648 to 2147483647 in 32 bit systems and
	//-9223372036854775808 to 9223372036854775807 in 64 bit systems

	//int8	8 bits/1 byte	-128 to 127
	//int16	16 bits/2 byte	-32768 to 32767
	//int32	32 bits/4 byte	-2147483648 to 2147483647
	//int64	64 bits/8 byte	-9223372036854775808 to 9223372036854775807

	var num8 int8 = 127
	fmt.Println(num8)

	//Unsigned integers, declared with one of the uint keywords, can only store non-negative values:
	//uint	Depends on platform:
	//32 bits in 32 bit systems and
	//64 bit in 64 bit systems	0 to 4294967295 in 32 bit systems and
	//0 to 18446744073709551615 in 64 bit systems
	//uint8	8 bits/1 byte	0 to 255
	//uint16	16 bits/2 byte	0 to 65535
	//uint32	32 bits/4 byte	0 to 4294967295
	//uint64	64 bits/8 byte	0 to 18446744073709551615
	var numu8 uint8 = 255
	fmt.Println(numu8)

	//Alias
	//int32 = rune
	//BYTE = uint8

	//FLOAT -
	//float32	32 bits	-3.4e+38 to 3.4e+38.
	//float64	64 bits	-1.7e+308 to +1.7e+308.

	var numeroreal1 float32 = 123.22
	fmt.Println(numeroreal1)

	var numeroreal2 float64 = 12242412143.2222
	fmt.Println(numeroreal2)

	numeroreal3 := 12312.22
	fmt.Println(numeroreal3)

	fmt.Println("'---------------------------------------------")

	//Str
	var str1 string = "String 1"
	fmt.Println(str1)

	str2 := "String 2"
	fmt.Println(str2)

	fmt.Println("'---------------------------------------------")
	//Char - Sempre retornará o INT da tabela ASC
	var char1 = 'A'
	fmt.Println(char1)

	//Error

	var erro error = errors.New("Larçando um novo erro! ")
	fmt.Println(erro)

}
