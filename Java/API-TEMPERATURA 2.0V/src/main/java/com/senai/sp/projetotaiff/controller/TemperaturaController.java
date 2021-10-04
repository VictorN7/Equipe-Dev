package com.senai.sp.projetotaiff.controller;

import java.util.List;

import com.senai.sp.projetotaiff.interfaces.Interface_Temperatura;
import com.senai.sp.projetotaiff.repository.VbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senai.sp.projetotaiff.modal.Temperatura;

import javax.transaction.Transactional;

@RestController
public class TemperaturaController {

    @Autowired
    Interface_Temperatura interface_temperatura;

    private final VbaService _vbaService;

    public TemperaturaController(VbaService _vbaService) {
        this._vbaService = _vbaService;
    }

    @RequestMapping(value = "/listarTemps", method = RequestMethod.GET, produces = {"application/json"})
    public List<Temperatura> listarTodosTestes() {
        return interface_temperatura.findAll();
    }

    @RequestMapping(value = "/adicionarTemp", method = RequestMethod.POST)
    @Transactional
    public ResponseEntity<Temperatura> createTeste(@RequestBody Temperatura temperatura) {
        interface_temperatura.save(temperatura);
        return ResponseEntity.created(null).body(temperatura);
    }
}
