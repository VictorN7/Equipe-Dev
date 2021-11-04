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

import com.senai.sp.projetotaiff.modal.ZeroPeca;
import com.senai.sp.projetotaiff.repository.ZeroPecaRepository;


@RestController
@RequestMapping("/zeropeca")
public class ZeroPecaController {

	
	@Autowired
	ZeroPecaRepository zpRepository;
	
	@GetMapping
	public List<ZeroPeca> ListarTodos()
	{
		return zpRepository.listarTodosZeroPeca();
	}
	
	@GetMapping("/{id}")
	public ZeroPeca PegarId(@PathVariable int id)
	{
	  return zpRepository.buscarZeroPecaId(id);
	}
	
	@PostMapping
	public ZeroPeca inserirPecaZeroPeca(@RequestBody ZeroPeca zeropeca)
	{
	   	zpRepository.inserirZeroPeca(zeropeca);
		return zeropeca;
	}
	
	@PutMapping("/{id}")
	public ZeroPeca alterarZeroPeca(@PathVariable int id,@RequestBody ZeroPeca zeropeca)
	{
		zpRepository.alterarZeroPeca(id, zeropeca);
		return zeropeca;
	}
	
	
	@DeleteMapping("/{id}")
	public int excluir(@PathVariable int id)
	{
		zpRepository.excluirZeroPeca(id);
		return id;
	}

}
