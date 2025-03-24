// cmd/main.go
package main

import (
	"Project-GO-clean-architeture/configs"
	"Project-GO-clean-architeture/internal/core/usecases"
	"Project-GO-clean-architeture/internal/infra/kafka"
	"Project-GO-clean-architeture/internal/infra/repositories"
	"context"
	"log"
)

func main() {
	cfg := configs.LoadConfig()

	// Configuração do MongoDB
	client, err := mongo.Connect(context.Background(), options.Client().ApplyURI(cfg.MongoURI))
	if err != nil {
		log.Fatalf("Erro ao conectar ao MongoDB: %v", err)
	}
	collection := client.Database("sup_nexus").Collection("lojas")
	repo := repositories.NewMongoRepository(collection)

	// Configuração de Kafka
	consumer := kafka.NewKafkaConsumer(cfg.KafkaBroker, "lojas-consumer-group")
	producer := kafka.NewKafkaProducer(cfg.KafkaBroker)

	// Inicializa UseCase e Kafka Listener
	useCase := usecases.NewLojaUseCase(repo)
	listener := kafka.NewKafkaListener(consumer, producer, useCase, cfg.DLQTopic, cfg.OutputTopic)
	listener.Start(cfg.InputTopic)
}
