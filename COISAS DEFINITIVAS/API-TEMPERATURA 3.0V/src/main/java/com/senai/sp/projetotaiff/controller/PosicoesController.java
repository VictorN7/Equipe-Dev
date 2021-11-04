package com.senai.sp.projetotaiff.controller;

import com.senai.sp.projetotaiff.modal.Posicoes;
import com.senai.sp.projetotaiff.repository.MachinePosicaoService;
import com.senai.sp.projetotaiff.repository.PosicoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posicoes")

public class PosicoesController {

    @Autowired
    PosicoesRepository posicoesRepository;

    @Autowired
    MachinePosicaoService  machinePosicaoService;

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

    @GetMapping(value = "/Teste/{id}")
    public String Machine(@PathVariable int id){
       machinePosicaoService.machinePosi(id);
       return "chegou aqui";
    }
}
