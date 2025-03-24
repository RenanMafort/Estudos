package configs

import "os"

type Config struct {
	MongoURI    string
	KafkaBroker string
	InputTopic  string
	OutputTopic string
	DLQTopic    string
}

func LoadConfig() Config {
	return Config{
		MongoURI:    os.Getenv("MONGO_URI"),
		KafkaBroker: os.Getenv("KAFKA_BROKER"),
		InputTopic:  os.Getenv("KAFKA_INPUT_TOPIC"),
		OutputTopic: os.Getenv("KAFKA_OUTPUT_TOPIC"),
		DLQTopic:    os.Getenv("KAFKA_DLQ_TOPIC"),
	}
}
