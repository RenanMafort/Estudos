// internal/core/usecases/loja_usecase.go
package usecases

import (
	"Project-GO-clean-architeture/internal/core/models"
	"Project-GO-clean-architeture/internal/infra/repositories"
)

type LojaUseCase struct {
	repo repositories.LojaRepository
}

func NewLojaUseCase(repo repositories.LojaRepository) *LojaUseCase {
	return &LojaUseCase{repo: repo}
}

func (uc *LojaUseCase) ProcessMessage(message models.KafkaMessageConsumer) error {
	// Simula o enriquecimento chamando uma API externa
	enrichedLoja := uc.enrichLoja(message.LojaID)

	switch message.Acao {
	case "INSERT":
		return uc.repo.Insert(enrichedLoja)
	case "UPDATE":
		return uc.repo.Update(enrichedLoja)
	case "DELETE":
		return uc.repo.Delete(message.LojaID)
	}
	return nil
}

func (uc *LojaUseCase) enrichLoja(id int) models.Loja {
	// Implementação da chamada à API externa omitida
	return models.Loja{CdLoja: id}
}
