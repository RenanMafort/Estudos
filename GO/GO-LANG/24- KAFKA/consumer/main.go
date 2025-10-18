package main

import (
	"fmt"
	"log"
	"os"
	"os/signal"
	"syscall"

	"github.com/IBM/sarama"
)

func main() {
	// Configuração do consumidor
	config := sarama.NewConfig()
	config.Consumer.Return.Errors = true

	brokers := []string{"192.168.237.170:9092"}

	// Criar consumidor
	consumer, err := sarama.NewConsumer(brokers, config)
	if err != nil {
		log.Fatalf("Erro ao criar consumidor: %v", err)
	}
	defer func() {
		if err := consumer.Close(); err != nil {
			log.Fatalf("Erro ao fechar consumidor: %v", err)
		}
	}()

	// Consumir mensagens da partição
	partitionConsumer, err := consumer.ConsumePartition("meu-topico", 0, sarama.OffsetOldest)
	if err != nil {
		log.Fatalf("Erro ao consumir partição: %v", err)
	}
	defer func() {
		if err := partitionConsumer.Close(); err != nil {
			log.Fatalf("Erro ao fechar consumidor de partição: %v", err)
		}
	}()

	// Capturar sinal para encerrar o programa com segurança
	signals := make(chan os.Signal, 1)
	signal.Notify(signals, os.Interrupt, syscall.SIGINT)

	// Consumir mensagens
	log.Println("Consumindo mensagens... Pressione Ctrl+C para sair.")
	for {
		select {
		case msg := <-partitionConsumer.Messages():
			fmt.Printf("Mensagem recebida: %s\n", string(msg.Value))
		case err := <-partitionConsumer.Errors():
			log.Printf("Erro recebido: %v", err)
		case <-signals:
			log.Println("Encerrando o consumidor.")
			return
		}
	}
}
