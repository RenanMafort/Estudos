// internal/infra/kafka/kafka.go
package kafka

import "context"

type KafkaConsumer interface {
	Consume(ctx context.Context, topic string) <-chan kafka.Message
}

type KafkaProducer interface {
	Produce(ctx context.Context, topic string, key []byte, value []byte) error
}
