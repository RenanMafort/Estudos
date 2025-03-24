// internal/infra/kafka/consumer.go
package kafka

import (
	"context"
	"log"
)

type KafkaConsumerImpl struct {
	reader *kafka.Reader
}

func NewKafkaConsumer(broker, groupID string) *KafkaConsumerImpl {
	return &KafkaConsumerImpl{
		reader: kafka.NewReader(kafka.ReaderConfig{
			Brokers:  []string{broker},
			GroupID:  groupID,
			MinBytes: 10e3, // 10KB
			MaxBytes: 10e6, // 10MB
		}),
	}
}

func (kc *KafkaConsumerImpl) Consume(ctx context.Context, topic string) <-chan kafka.Message {
	messages := make(chan kafka.Message)

	go func() {
		defer close(messages)
		kc.reader.SetOffset(kafka.FirstOffset)
		if err := kc.reader.SetTopics(topic); err != nil {
			log.Printf("Erro ao configurar tópico: %v", err)
			return
		}
		for {
			msg, err := kc.reader.FetchMessage(ctx)
			if err != nil {
				log.Printf("Erro ao consumir mensagem: %v", err)
				return
			}
			messages <- msg
		}
	}()

	return messages
}
