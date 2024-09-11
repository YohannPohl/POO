package com.apimanipular.jpa_api.service;


import com.apimanipular.jpa_api.exceptions.ResourceNotFoundException;
import com.apimanipular.jpa_api.exceptions.TaskAlreadyFinalizedException;
import com.apimanipular.jpa_api.model.Tarefa;
import com.apimanipular.jpa_api.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa inserirTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscarTarefaPorId(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com o id " + id));
    }

    public List<Tarefa> listarTodasTarefas() {
        return tarefaRepository.findAll();
    }

    public List<Tarefa> listarTarefasNaoFinalizadas() {
        return tarefaRepository.findByFinalizado(false);
    }

    public List<Tarefa> listarTarefasFinalizadas() {
        return tarefaRepository.findByFinalizado(true);
    }

    public List<Tarefa> listarTarefasAtrasadas() {
        return tarefaRepository.findByFinalizadoIsFalseAndDataPrevistaFinalizacaoBefore(LocalDate.now());
    }

    public List<Tarefa> listarTarefasNaoFinalizadasEntreDatas(LocalDate inicio, LocalDate fim) {
        return tarefaRepository.findByFinalizadoAndDataPrevistaFinalizacaoBetween(false, inicio, fim);
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
        Tarefa tarefaExistente = buscarTarefaPorId(id);
        if (tarefaExistente.isFinalizado()) {
            throw new TaskAlreadyFinalizedException("Tarefa finalizada não pode ser alterada");
        }
        tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
        tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
        tarefaExistente.setDataPrevistaFinalizacao(tarefaAtualizada.getDataPrevistaFinalizacao());
        return tarefaRepository.save(tarefaExistente);
    }

    public void deletarTarefa(Long id) {
        Tarefa tarefa = buscarTarefaPorId(id);
        if (tarefa.isFinalizado()) {
            throw new TaskAlreadyFinalizedException("Tarefa finalizada não pode ser excluída");
        }
        tarefaRepository.delete(tarefa);
    }

    public Tarefa finalizarTarefa(Long id) {
        Tarefa tarefa = buscarTarefaPorId(id);
        tarefa.setFinalizado(true);
        tarefa.setDataFinalizacao(LocalDate.now());
        return tarefaRepository.save(tarefa);
    }
}