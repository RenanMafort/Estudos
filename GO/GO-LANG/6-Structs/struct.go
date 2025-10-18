package main

import "fmt"

type usuario struct {
	nome     string
	idade    int
	email    string
	endereco endereco
}

type endereco struct {
	rua    string
	bairro string
	cidade string
}

func main() {

	var u usuario
	u.nome = "Renan"
	u.idade = 20
	u.email = "renan@teste.com"

	fmt.Println(u)

	var endereco1 = endereco{"rua teste", "bairro teste", "cidade teste"}

	usuario2 := usuario{"renan", 22, "renan.teste@hotmail.com", endereco1}
	fmt.Println(usuario2)

	usuario3 := usuario{nome: "renan"}
	fmt.Println(usuario3)
}
