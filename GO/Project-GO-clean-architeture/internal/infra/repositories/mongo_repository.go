package repositories

import (
	"Project-GO-clean-architeture/internal/core/models"
	"context"
	"log"
)

type MongoRepository struct {
	collection *mongo.Collection
}

func NewMongoRepository(collection *mongo.Collection) *MongoRepository {
	return &MongoRepository{collection: collection}
}

// internal/infra/repositories/mongo_repository.go
func (m *MongoRepository) Insert(loja models.Loja) error {
	_, err := m.collection.InsertOne(context.Background(), loja)
	if err != nil {
		log.Printf("Erro ao inserir loja no MongoDB: %v", err)
		return err
	}
	return nil
}

func (m *MongoRepository) Update(loja models.Loja) error {
	filter := bson.M{"cdLoja": loja.CdLoja}
	_, err := m.collection.ReplaceOne(context.Background(), filter, loja)
	if err != nil {
		log.Printf("Erro ao atualizar loja no MongoDB: %v", err)
		return err
	}
	return nil
}

func (m *MongoRepository) Delete(id int) error {
	filter := bson.M{"cdLoja": id}
	_, err := m.collection.DeleteOne(context.Background(), filter)
	if err != nil {
		log.Printf("Erro ao deletar loja no MongoDB: %v", err)
		return err
	}
	return nil
}
