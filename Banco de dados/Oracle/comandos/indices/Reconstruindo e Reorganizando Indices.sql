--
-- Curso - Oracle SQL e Oracle SQL Avançado - Completo 2025
--
-- Autor - Emílio Scudero
--
-- Seção 24 - Índices
--
-- Aula 3 - Reconstruindo e  Reorganizando Índices

-- Reconstruindo e reorganizando um Índice

ALTER INDEX employees_last_name_first_name_idx REBUILD;

-- Reconstruindo e reorganizando um Índice com opção ONLINE

ALTER INDEX employees_last_name_first_name_idx REBUILD ONLINE;
