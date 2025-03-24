// internal/infra/kafka/producer.go
package kafka

import "context"

type KafkaProducerImpl struct {
	writer *kafka.Writer
}

func NewKafkaProducer(broker string) *KafkaProducerImpl {
	return &KafkaProducerImpl{
		writer: &kafka.Writer{
			Addr:     kafka.TCP(broker),
			Balancer: &kafka.LeastBytes{},
		},
	}
}

func (kp *KafkaProducerImpl) Produce(ctx context.Context, topic string, key []byte, value []byte) error {
	message := kafka.Message{
		Topic: topic,
		Key:   key,
		Value: value,
	}
	return kp.writer.WriteMessages(ctx, message)
}
