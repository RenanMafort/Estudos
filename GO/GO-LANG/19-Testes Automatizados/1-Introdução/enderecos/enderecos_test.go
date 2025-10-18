package enderecos_test

import (
	"introducao-testes/enderecos"
	"testing"
)

func TestQualquer(t *testing.T) {
	t.Parallel()
	if 1 > 2 {
		t.Errorf("Testandoo!")
	}
}

type cenarioTest struct {
	enderecoInserido string
	enderecoEsperado string
}

func TestTipoDeEndereco(t *testing.T) {
	t.Parallel()
	cenariosDeTeste := []cenarioTest{
		{"Rua ABC", "Rua"},
		{"Avenida Paulista", "Avenida"},
		{"Rodovia dos Imigrantes", "Rodovia"},
		//{"Praça das Rosas", "Tipo Inválido"},
		{"Estrada Qualquer", "Estrada"},
		{"RUA DOS BOBOS", "Rua"},
		{"AVENIDA REBOUÇAS", "Avenida"},
		//{"", "Tipo Inválido"},
	}

	for _, cenariosTest := range cenariosDeTeste {
		resultadoFuncao := enderecos.TipoDeEndereco(cenariosTest.enderecoInserido)

		if resultadoFuncao != cenariosTest.enderecoEsperado {
			t.Errorf("O tipo recebido %s é diferente do esperado %s",
				resultadoFuncao,
				cenariosTest.enderecoEsperado,
			)
		}
	}

}

//func TestTipoDeEndereco(t *testing.T) {
//	endereco := "Rua Paulista"
//	enderecoEsperado := "Rua"
//	retornoRecebido := enderecos.TipoDeEndereco(endereco)
//
//	if retornoRecebido != enderecoEsperado {
//		t.Errorf("Tipo de endereço retornado é Inválido! Esperado: %s, Recebido: %s", enderecoEsperado, retornoRecebido)
//	}
//
//}
