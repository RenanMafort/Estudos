package repositories

import "Project-GO-clean-architeture/internal/core/models"

type LojaRepository interface {
	Insert(loja models.Loja) error
	Update(loja models.Loja) error
	Delete(id int) error
	GetByID(id int) (models.Loja, error)
	List(pagination int, limit int) ([]models.Loja, error)
}
