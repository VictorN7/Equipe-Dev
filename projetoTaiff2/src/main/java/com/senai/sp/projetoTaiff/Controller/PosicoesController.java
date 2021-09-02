package com.senai.sp.projetoTaiff.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.senai.sp.projetoTaiff.Modal.Posicoes;
import com.senai.sp.projetoTaiff.Repository.PosicoesRepository;


@RestController
public class PosicoesController {
	
	@Autowired
	PosicoesRepository posicoesRepository;

	@RequestMapping(value = "/listarTodasPosicoes", produces = {"application/json"}, method = RequestMethod.GET)
	public List<Posicoes> ListarTodos() {
		return posicoesRepository.listarTodasPosicoes();
	}

	@RequestMapping(value = "/listarPosicoesPorId/{id}", method = RequestMethod.GET, produces = {"application/json"})
	public Posicoes PegarId(@PathVariable int id) {
	  return posicoesRepository.buscarPosicoesId(id);
	}

	@RequestMapping(value = "/adicionarPosicoes", produces = {"application/json"}, method = RequestMethod.POST)
	public Posicoes inserir(@RequestBody Posicoes posi) {
		posicoesRepository.inserirPosicoes(posi);
		return posi;
	}

	@RequestMapping(value = "alterarPosicoes/{id}", method = RequestMethod.PUT)
	public Posicoes alterar(@PathVariable int id,@RequestBody Posicoes posi) {
		posicoesRepository.alterarPosicoes(id, posi);
		return posi;
	}

	@RequestMapping(value = "/deletarPosicoes/{id}", method = RequestMethod.DELETE)
	public int excluir(@PathVariable int id) {
		posicoesRepository.excluirPosicoes(id);
		return id;
	}

	@RequestMapping(value = "/deletarPosicoesIdTeste/{id}", method = RequestMethod.DELETE)
	public int excluirPorIdTeste(@PathVariable int id) {
		posicoesRepository.excluirPosicoesPorIdTeste(id);
		return id;
	}
}
