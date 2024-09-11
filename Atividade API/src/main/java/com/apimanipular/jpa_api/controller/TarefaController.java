package com.apimanipular.jpa_api.controller;

import com.apimanipular.jpa_api.model.Tarefa;
import com.apimanipular.jpa_api.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tares")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public Tarefa inserirTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.inserirTarefa(tarefa);
    }

    @GetMapping
    public List<Tarefa> listarTodasTarefas() {
        return tarefaService.listarTodasTarefas();
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefaPorId(@PathVariable Long id) {
        return tarefaService.buscarTarefaPorId(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @Valid @RequestBody Tarefa tarefaAtualizada) {
        return tarefaService.atualizarTarefa(id, tarefaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
    }

    @GetMapping("/nao-finalizadas")
    public List<Tarefa> listarTarefasNaoFinalizadas() {
        return tarefaService.listarTarefasNaoFinalizadas();
    }

    @GetMapping("/finalizadas")
    public List<Tarefa> listarTarefasFinalizadas() {
        return tarefaService.listarTarefasFinalizadas();
    }

    @GetMapping("/atrasadas")
    public List<Tarefa> listarTarefasAtrasadas() {
        return tarefaService.listarTarefasAtrasadas();
    }

    @GetMapping("/nao-finalizadas-entre")
    public List<Tarefa> listarTarefasNaoFinalizadasEntreDatas(@RequestParam LocalDate inicio, @RequestParam LocalDate fim) {
        return tarefaService.listarTarefasNaoFinalizadasEntreDatas(inicio, fim);
    }

    @PutMapping("/{id}/finalizar")
    public Tarefa finalizarTarefa(@PathVariable Long id) {
        return tarefaService.finalizarTarefa(id);
    }
}