package main

import "fmt"

func main() {

	num := 20
	if num > 20 {
		fmt.Println("Maior que 20")
	} else if num < 20 {
		fmt.Println("Menor que 20")
	}

	//IF INIT
	if outroNumero := num; outroNumero >= 20 {
		fmt.Println("Outro numero maior que 20")
	}

	//SWITCH
	num2 := 10
	switch num2 {
	case 10:
		fmt.Println("10")
	case 20:
		fmt.Println("20")
	default:
		fmt.Println("Outro")
	}

	switch {
	case num2 == 1:
		fmt.Println("1")
	case num == 2:
		fmt.Println("2")
	case num == 3:
		fmt.Println("3")
	default:
		fmt.Println("Helooooo")
	}

	switch {
	case num2 == 1:
		fmt.Println("1")
		fallthrough
	case num == 2:
		fmt.Println("2")
	case num == 3:
		fmt.Println("3")
	default:
		fmt.Println("Helooooo")
	}

}
