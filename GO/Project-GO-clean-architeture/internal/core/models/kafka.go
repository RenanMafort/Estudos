package models

type KafkaMessageConsumer struct {
	LojaID int    `json:"loja_id"`
	Acao   string `json:"acao"`
	AcaoID int    `json:"acao_id"`
}
