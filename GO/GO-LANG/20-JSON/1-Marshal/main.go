package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"log"
)

type carro struct {
	Marca string `json:"marca"`
	Cor   string `json:"cor"`
	Ano   uint16 `json:"anoo"`
}

func main() {

	carro1 := carro{"VW", "RED", 2024}
	marshalJSON, erro := json.Marshal(carro1)
	if erro != nil {
		log.Fatal(erro)
	}

	fmt.Println(marshalJSON)                  // Em bytes
	fmt.Println(bytes.NewBuffer(marshalJSON)) // Em JSON

	carro2 := map[string]any{
		"nome": "FORD",
		"cor":  "BLUE",
		"ano":  2024,
	}
	carro2JSON, erro := json.Marshal(carro2)
	fmt.Println(bytes.NewBuffer(carro2JSON))

}
