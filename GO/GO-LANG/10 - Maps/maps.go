package main

import "fmt"

func main() {

	var maps = make(map[int8]string)
	maps[1] = "Renan"
	maps[2] = "Renan"
	maps[3] = "Renan"
	fmt.Println(maps)

	maps2 := map[int32]map[int32]string{
		1: {
			1: "renan",
			2: "Mafort",
			3: "Sereia",
		},
		2: {
			1: "renan",
			2: "Mafort",
			3: "Sereia",
		},
	}

	fmt.Println(maps2)

	//DELETANDO
	delete(maps2, 2)
	fmt.Println(maps2)

	maps2[1] = map[int32]string{
		1: "renan",
		2: "Mafort",
		3: "222222",
	}
	fmt.Println(maps2)
}
