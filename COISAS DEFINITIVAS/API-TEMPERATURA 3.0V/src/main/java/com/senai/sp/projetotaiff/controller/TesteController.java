package com.senai.sp.projetotaiff.controller;

import com.senai.sp.projetotaiff.modal.Teste;
import com.senai.sp.projetotaiff.repository.TesteRepository;
import com.senai.sp.projetotaiff.repository.VbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class TesteController {

    @Autowired
    TesteRepository testeRepository;
    private final VbaService vbaService;

    public TesteController(VbaService vbaService) {
        this.vbaService = vbaService;
    }

    @GetMapping(value = "/listarTodosTeste", produces = {"application/json"})
    public List<Teste> listarTodosTestes(){
        return testeRepository.listaTodosTestes();
    }

    @GetMapping(value = "/listarTestePorId/{id}", produces = {"application/json"})
    public Teste buscarTesteId(@PathVariable int id){
        return testeRepository.buscarTesteId(id);
    }

    @PostMapping(value = "/adicionarTeste")
    public Teste inserirTesteCompleto(@RequestBody Teste teste){
        return testeRepository.inserirTeste(teste);
    }
    
    @PostMapping(value = "/adicionarTesteEZeroPeca")
    public Teste inserirTesteEZeroPeca(@RequestBody Teste teste){
        return testeRepository.inserirTesteEZeroPeca(teste);
    }

    @PutMapping(value = "alterarTeste/{id}"	)
            public Teste alterar(@RequestBody Teste teste, @PathVariable int id) {
    	testeRepository.alterarTeste(teste, id);
		return teste;
	}

    @PutMapping(value = "alterarNomeModelo/{id}")
    public  Teste alterarModelo(@PathVariable int id,@RequestBody Teste teste){
        testeRepository.alterarNomeModelo(id,teste);
        return teste;
    }

    @DeleteMapping(value = "/deletarTeste/{id}")
	public int excluir(@PathVariable int id) {
		testeRepository.excluirTeste(id);
		return id;
	}

    @GetMapping(value = "/downloadCSV",produces = {"application/json"})
    public void downloadCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"teste.csv\"");
        vbaService.vbaFuncAutoWindow(servletResponse.getWriter());
    }
    
    @GetMapping(value = "/downloadCSVPuro", produces = {"application/json"})
    public void downloadCsvPuro(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"Relatório_Puro.csv\"");
        vbaService.vbaFuncPuro(servletResponse.getWriter());
    }
}
