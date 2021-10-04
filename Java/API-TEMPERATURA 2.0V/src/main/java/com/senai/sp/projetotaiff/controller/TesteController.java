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


    //   private final CsvService csvService;
//
//    public TesteController(CsvService csvService) {
//        this.csvService = csvService;
//    }
    private final VbaService vbaService;

    public TesteController(VbaService vbaService) {
        this.vbaService = vbaService;
    }

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

    @RequestMapping(value = "/downloadCSV", method = RequestMethod.GET, produces = {"application/json"})
    public void downloadCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"Relatorio_Processado.csv\"");
        vbaService.vbaFuncAutoWindow(servletResponse.getWriter());
    }

    @RequestMapping(value = "/downloadCSVPuro", method = RequestMethod.GET, produces = {"application/json"})
    public void downloadCsvPuro(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"Relatório_Puro.csv\"");
        vbaService.vbaFuncPuro(servletResponse.getWriter());
    }
}

