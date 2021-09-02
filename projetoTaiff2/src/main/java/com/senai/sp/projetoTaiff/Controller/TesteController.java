package com.senai.sp.projetoTaiff.Controller;

import com.senai.sp.projetoTaiff.Modal.Teste;
import com.senai.sp.projetoTaiff.Repository.TesteRepository;
import com.senai.sp.projetoTaiff.Repository.ZeroPecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TesteController {

    @Autowired
    TesteRepository testeRepository;

    @Autowired
    ZeroPecaRepository zeroPecaRepository;

    @RequestMapping(value = "/listarTodosTeste", method = RequestMethod.GET, produces = {"application/json"})
    public List<Teste> listarTodosTestes() {
        return testeRepository.listaTodosTestes();
    }

    @RequestMapping(value = "/listarTestePorId/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Teste buscarTesteId(@PathVariable int id) {
        return testeRepository.buscarTesteId(id);
    }

    @RequestMapping(value = "/adicionarTeste", method = RequestMethod.POST)
    public Teste inserirTesteCompleto(@RequestBody Teste teste) {
        return testeRepository.inserirTeste(teste);
    }

    @RequestMapping(value = "alterarTeste/{id}", method = RequestMethod.PUT)
    public Teste alterar(@RequestBody Teste teste, @PathVariable int id) {
        testeRepository.alterarTeste(teste, id);
        return teste;
    }

    @RequestMapping(value = "/deletarTeste/{id}", method = RequestMethod.DELETE)
    public int excluir(@PathVariable int id) {
        testeRepository.excluirTeste(id);
        return id;
    }
}
