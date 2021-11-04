package com.senai.sp.projetotaiff.repository;


import com.senai.sp.projetotaiff.interfaces.Interface_Temperatura;
import com.senai.sp.projetotaiff.modal.Posicoes;
import com.senai.sp.projetotaiff.modal.Temperatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;


@Repository
public class MachinePosicaoService {

    Logger logger = Logger.getLogger("com.senai.sp.projetoTaiff.repository");

    private final Interface_Temperatura interface_temperatura;


    public MachinePosicaoService(Interface_Temperatura interface_temperatura) {
        this.interface_temperatura = interface_temperatura;
    }


    @Autowired
    TesteRepository testeRepository;


    public void machinePosi(int id) {

        List<Posicoes> listPosiTeste = testeRepository.buscarTesteId(id).getPosicao();
        listPosiTeste.forEach(posicoes -> {

            try {
                Thread.sleep(5000);
                logger.log(Level.SEVERE, () -> "\n\nN° Posicoes: " + posicoes.getId_posicao() + "\n");
                logger.log(Level.SEVERE, () -> "\n\nTempo Posicoes: " + posicoes.getPosiT() + "\n");

            } catch (InterruptedException e) {

                logger.log(Level.WARNING, "Algo deu errado", e);
                Thread.currentThread().interrupt();
            }


            AtomicInteger contador = new AtomicInteger(1);

            for (int j = 0; j < posicoes.getPosiT(); j++) {
                try {

                    Temperatura temp = new Temperatura();
                    temp.setId_posicao(posicoes.getId_posicao());
                    temp.setTermopar1(Math.random() * 100);
                    temp.setTermopar2(Math.random() * 100);
                    temp.setTermopar3(Math.random() * 100);
                    temp.setTempAmb(Math.random() * 100);
                    temp.setData_leitura(LocalDate.now());


                    Thread.sleep(1000);
                    logger.log(Level.INFO, () -> "Contagem- " + contador.getAndIncrement());
                    logger.log(Level.INFO, () -> "\tData de Leitura- " + temp.getData_leitura());
                    logger.log(Level.INFO, () -> "\tTermo1- " + temp.getTermopar1());
                    logger.log(Level.INFO, () -> "\tTermo2- " + temp.getTermopar2());
                    logger.log(Level.INFO, () -> "\tTermo3- " + temp.getTermopar3());
                    logger.log(Level.INFO, () -> "\tTempAmb- " + temp.getTempAmb());


                    interface_temperatura.save(temp);


                } catch (Exception e) {

                    logger.log(Level.WARNING, "Algo deu errado", e);
                    Thread.currentThread().interrupt();

                }
            }
        });


    }


}


