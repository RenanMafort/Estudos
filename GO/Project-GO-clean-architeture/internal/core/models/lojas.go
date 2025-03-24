package models

type Loja struct {
	CdLoja           int     `json:"cdLoja"`
	CdCnpjLoja       string  `json:"cdCnpjLoja"`
	NoLoja           string  `json:"noLoja"`
	SlLoja           string  `json:"slLoja"`
	DtAberturaLoja   string  `json:"dtAberturaLoja"`
	DtFechamentoLoja *string `json:"dtFechamentoLoja"`
	InExclusao       string  `json:"inExclusao"`
	// Outros campos omitidos por brevidade
}
