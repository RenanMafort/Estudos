package main

import (
	"github.com/IBM/sarama"
	"log"
)

func main() {
	// Configuração do produtor
	config := sarama.NewConfig()
	config.Producer.Return.Successes = true

	// Endereço do broker Kafka
	brokers := []string{"192.168.237.170:9092"}

	// Criar produtor síncrono
	producer, err := sarama.NewSyncProducer(brokers, config)
	if err != nil {
		log.Fatalf("Erro ao criar produtor: %v", err)
	}
	defer func() {
		if err := producer.Close(); err != nil {
			log.Fatalf("Erro ao fechar produtor: %v", err)
		}
	}()

	// Criar mensagem
	message := &sarama.ProducerMessage{
		Topic: "meu-topico",
		Value: sarama.StringEncoder("MEU MACACAO DA ESCOLA É UM AMIGO"),
	}

	// Enviar mensagem
	partition, offset, err := producer.SendMessage(message)
	if err != nil {
		log.Fatalf("Erro ao enviar mensagem: %v", err)
	}

	// Exibir informações da mensagem enviada
	log.Printf("Mensagem enviada para o tópico \"meu-topico\" na partição \"%d\" e no offset \"%d\"", partition, offset)
}
