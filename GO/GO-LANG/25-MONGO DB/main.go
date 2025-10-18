package main

import (
	"context"
	"fmt"
	"log"
	"time"

	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
)

func main() {
	// Configurar contexto para MongoDB
	ctx, cancel := context.WithTimeout(context.Background(), 10*time.Second)
	defer cancel()

	// Conectar ao MongoDB
	client, err := mongo.Connect(ctx, options.Client().ApplyURI("mongodb://pedido:pedido@192.168.237.170:27017"))
	if err != nil {
		log.Fatalf("Erro ao conectar ao MongoDB: %v", err)
	}

	// Selecionar a coleção
	collection := client.Database("test").Collection("lojas")

	// Inserir documento
	one, err := collection.InsertOne(ctx, bson.M{
		"id":   2,
		"nome": "Renan Sereia",
	})
	if err != nil {
		log.Fatalf("Erro ao inserir documento: %v", err)
	}
	
	// Exibir ID do documento inserido
	fmt.Printf("Documento inserido com ID: %v\n", one.InsertedID)
}
