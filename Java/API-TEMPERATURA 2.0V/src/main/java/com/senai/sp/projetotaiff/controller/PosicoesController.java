package com.senai.sp.projetotaiff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.sp.projetotaiff.modal.Posicoes;
import com.senai.sp.projetotaiff.repository.PosicoesRepository;


@RestController
@RequestMapping("/posicoes")

public class PosicoesController {

    @Autowired
    PosicoesRepository posicoesRepository;

    @GetMapping
    public List<Posicoes> ListarTodos() {
        return posicoesRepository.listarTodasPosicoes();
    }

    @GetMapping("/{id}")
    public Posicoes PegarId(@PathVariable int id) {
        return posicoesRepository.buscarPosicoesId(id);
    }

    @PostMapping
    public Posicoes inserir(@RequestBody Posicoes posi) {
        posicoesRepository.inserirPosicoes(posi);
        return posi;
    }

    @PutMapping("/{id}")
    public Posicoes alterar(@PathVariable int id, @RequestBody Posicoes posi) {
        posicoesRepository.alterarPosicoes(id, posi);
        return posi;
    }

    @DeleteMapping("/{id}")
    public int excluir(@PathVariable int id) {
        posicoesRepository.excluirPosicoes(id);
        return id;
    }

    @DeleteMapping("/deletarPorId/{id}")
    public int excluirPorIdTeste(@PathVariable int id) {
        posicoesRepository.excluirPosicoesPorIdTeste(id);
        return id;
    }
}
