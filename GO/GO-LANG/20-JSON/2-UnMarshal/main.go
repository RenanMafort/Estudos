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
	fmt.Println(bytes.NewBuffer(marshalJSON)) // Em bytes

	//UnMarshal
	jsonString := `{"marca":"VW","cor":"RED","anoo":2024}`

	var c2 carro

	err := json.Unmarshal([]byte(jsonString), &c2)
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println(c2)

	c3 := make(map[string]any)

	if erros := json.Unmarshal([]byte(jsonString), &c3); erros != nil {
		log.Fatal(erros)
	}
	fmt.Println(c3)

}
