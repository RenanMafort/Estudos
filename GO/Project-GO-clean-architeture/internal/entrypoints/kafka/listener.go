// internal/entrypoints/kafka/listener.go
package kafka

import (
	"context"
	"encoding/json"
	"log"
	"sup-nexus-lojas-api/internal/core/models"
	"sup-nexus-lojas-api/internal/core/usecases"
)

type KafkaListener struct {
	consumer    KafkaConsumer
	producer    KafkaProducer
	useCase     *usecases.LojaUseCase
	dlqTopic    string
	outputTopic string
}

func NewKafkaListener(consumer KafkaConsumer, producer KafkaProducer, useCase *usecases.LojaUseCase, dlqTopic, outputTopic string) *KafkaListener {
	return &KafkaListener{
		consumer:    consumer,
		producer:    producer,
		useCase:     useCase,
		dlqTopic:    dlqTopic,
		outputTopic: outputTopic,
	}
}

func (k *KafkaListener) Start(topic string) {
	messages := k.consumer.Consume(context.Background(), topic)
	for message := range messages {
		var kafkaMessage models.KafkaMessage
		err := json.Unmarshal(message.Value, &kafkaMessage)
		if err != nil {
			log.Printf("Erro ao desserializar mensagem: %v", err)
			k.sendToDLQ(message.Value, "UNMARSHAL_ERROR", "Erro ao desserializar mensagem", err.Error())
			continue
		}

		if err := k.useCase.ProcessMessage(kafkaMessage); err != nil {
			log.Printf("Erro no processamento da mensagem: %v", err)
			k.sendToDLQ(message.Value, "PROCESSING_ERROR", "Erro no processamento da mensagem", err.Error())
			continue
		}

		// Enviar para o tópico de saída
		outputMessage, err := json.Marshal(kafkaMessage)
		if err != nil {
			log.Printf("Erro ao serializar mensagem de saída: %v", err)
			k.sendToDLQ(message.Value, "SERIALIZATION_ERROR", "Erro ao serializar mensagem de saída", err.Error())
			continue
		}

		if err := k.producer.Produce(context.Background(), k.outputTopic, nil, outputMessage); err != nil {
			log.Printf("Erro ao enviar mensagem para o tópico de saída: %v", err)
			k.sendToDLQ(message.Value, "PRODUCER_ERROR", "Erro ao enviar mensagem para o tópico de saída", err.Error())
		}
	}
}
}

// internal/entrypoints/kafka/listener.go
func (k *KafkaListener) sendToDLQ(message []byte, errorCode, errorMessage string, cause string) {
	dlqMessage := map[string]interface{}{
		"erro_code":            errorCode,
		"erro_message":         errorMessage,
		"service":              "sup-nexus-lojas-api",
		"request_message_body": string(message),
		"cause_by":             cause,
	}
	dlqPayload, err := json.Marshal(dlqMessage)
	if err != nil {
		log.Printf("Erro ao serializar mensagem para DLQ: %v", err)
		return
	}
	if err := k.producer.Produce(context.Background(), k.dlqTopic, nil, dlqPayload); err != nil {
		log.Printf("Erro ao enviar mensagem para DLQ: %v", err)
	}
}
