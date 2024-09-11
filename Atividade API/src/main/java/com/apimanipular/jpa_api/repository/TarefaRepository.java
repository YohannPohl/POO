package com.apimanipular.jpa_api.repository;

import com.apimanipular.jpa_api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByFinalizado(boolean finalizado);

    List<Tarefa> findByFinalizadoAndDataPrevistaFinalizacaoBetween(boolean finalizado, LocalDate inicio, LocalDate fim);

    List<Tarefa> findByFinalizadoIsFalseAndDataPrevistaFinalizacaoBefore(LocalDate data);
}