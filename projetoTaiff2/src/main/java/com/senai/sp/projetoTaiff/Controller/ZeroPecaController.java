package com.senai.sp.projetoTaiff.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.senai.sp.projetoTaiff.Modal.ZeroPeca;
import com.senai.sp.projetoTaiff.Repository.ZeroPecaRepository;


@RestController
public class ZeroPecaController {

	
	@Autowired
	ZeroPecaRepository zpRepository;

	@RequestMapping(value = "/listarTodosZeroPecas", produces = {"application/json"}, method = RequestMethod.GET)
	public List<ZeroPeca> ListarTodos()
	{
		return zpRepository.listarTodosZeroPeca();
	}

	@RequestMapping(value = "/listarZeroPecaPorId/{id}", method = RequestMethod.GET, produces = {"application/json"})
	public ZeroPeca PegarId(@PathVariable int id)
	{
	  return zpRepository.buscarZeroPecaId(id);
	}

	@RequestMapping(value = "/AdicionarZeroPeca",method = RequestMethod.POST)
	public ZeroPeca inserirPecaZeroPeca(@RequestBody ZeroPeca zeropeca)
	{
	   	zpRepository.inserirZeroPeca(zeropeca);
		return zeropeca;
	}

	@RequestMapping(value = "/alterarZeroPeca/{id}", method = RequestMethod.PUT)
	public ZeroPeca alterarZeroPeca(@PathVariable int id,@RequestBody ZeroPeca zeropeca)
	{
		zpRepository.alterarZeroPeca(id, zeropeca);
		return zeropeca;
	}


	@RequestMapping(value = "/deletarZeroPeca/{id}", method = RequestMethod.DELETE)
	public int excluir(@PathVariable int id)
	{
		zpRepository.excluirZeroPeca(id);
		return id;
	}

}
