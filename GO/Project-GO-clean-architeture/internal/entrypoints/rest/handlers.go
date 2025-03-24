// internal/entrypoints/rest/handlers.go
package rest

import (
	"Project-GO-clean-architeture/internal/infra/repositories"
	"encoding/json"
	"net/http"
)

type LojaHandler struct {
	repo repositories.LojaRepository
}

func NewLojaHandler(repo repositories.LojaRepository) *LojaHandler {
	return &LojaHandler{repo: repo}
}

func (h *LojaHandler) HealthCheck(w http.ResponseWriter, r *http.Request) {
	w.WriteHeader(http.StatusOK)
	w.Write([]byte("OK"))
}

func (h *LojaHandler) ListLojas(w http.ResponseWriter, r *http.Request) {
	lojas, _ := h.repo.List(0, 10) // Paginado
	json.NewEncoder(w).Encode(lojas)
}
