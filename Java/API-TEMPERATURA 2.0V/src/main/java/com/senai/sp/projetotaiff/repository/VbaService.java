package com.senai.sp.projetotaiff.repository;

import com.senai.sp.projetotaiff.interfaces.Interface_Temperatura;
import com.senai.sp.projetotaiff.modal.Temperatura;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class VbaService {

    private final Interface_Temperatura interface_temperatura;
    private static final Logger log = getLogger(VbaService.class);

    public VbaService(Interface_Temperatura interface_temperatura) {
        this.interface_temperatura = interface_temperatura;
    }

    public void vbaFuncAutoWindow(Writer writer) {

        List<Temperatura> listTermo = interface_temperatura.findAll();

        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(null, null, null, "Media");
            csvPrinter.printRecord(null, "Inicio", "Fim", "Termopar1", "Termopar2", "Termopar3", "TermoparAmb");

            int RAMP_UP_THRESHOLD = 5;
            int RAMP_DOWN_THRESHOLD = -3;

            double temp_old = 0;
            int Status = 0;
            int linhaIjanela;
            int linhaTjanela;
            int RAMP_UP_PAD = 30;
            int RAMP_DOWN_PAD = -10;
            double contM = 1;
            double zeraJt1 = 0, zeraJt2 = 0, zeraJt3 = 0, zeraJtAmb = 0;

            List<Integer> posiInicialList = new ArrayList<>();
            List<Integer> posiFinaisList = new ArrayList<>();

            for (int i = 2; i < listTermo.size(); i++) {

                var temp_new = (listTermo.get(i).getTermopar1()
                        + listTermo.get(i - 1).getTermopar1()
                        + listTermo.get(i - 2).getTermopar1()) / 3;
                if (i == 2) {
                    temp_old = temp_new;
                }
                double variacao_temp = temp_new - temp_old;
                temp_old = temp_new;
//                System.out.println("\tVariação entre elas:  " + variacao_temp);
                if (Status == 0 && variacao_temp >= RAMP_UP_THRESHOLD) {
                    linhaIjanela = i;
                    posiInicialList.add(linhaIjanela + RAMP_UP_PAD);
//                   System.out.println("\nJanela " + contJ + " Linha: " + linhaIjanela + "\n");
                    Status = 1;
                }
                if (Status == 1 && variacao_temp <= RAMP_DOWN_THRESHOLD) {
                    linhaTjanela = i;
                    posiFinaisList.add(linhaTjanela + RAMP_DOWN_PAD);
//                    System.out.println("\n Linha de Termino da Janela: " + linhaTjanela + "\n");
                    Status = 0;
                }
//                System.out.print("Isso é uma Janela 15(Sim) e 0(Não): " + janelaStatus);
            }
            for (int i = 0; i < 10; i++) {
//                System.out.println("\n\n Janela " + (i + 1) + "|Inicio: " + posiInicialList.get(i) + "| Fim: " + posiFinaisList.get(i) + "\n");
                for (int j = posiInicialList.get(i); j <= posiFinaisList.get(i); j++) {

                    double termopar1 = listTermo.get(j).getTermopar1();
                    double termopar2 = listTermo.get(j).getTermopar2();
                    double termopar3 = listTermo.get(j).getTermopar3();
                    double tempAmb = listTermo.get(j).getTempAmb();
                    contM++;
//                    System.out.println("\tN°: " + contM++ + "|Linha: " + j + "|\tTermoPar1: " + termopar1 + "|\tTermoPar2: " + termopar2 + "|\tTermoPar3: " + termopar3 + "|\tTempAmb: " + tempAmb);

                    zeraJt1 = termopar1 + zeraJt1;
                    zeraJt2 = termopar2 + zeraJt2;
                    zeraJt3 = termopar3 + zeraJt3;
                    zeraJtAmb = tempAmb + zeraJtAmb;

                    if (j == posiFinaisList.get(i)) {
                        DecimalFormat df = new DecimalFormat("###.00");
                        double mediaT1 = zeraJt1 / contM;
                        double mediaT2 = zeraJt2 / contM;
                        double mediaT3 = zeraJt3 / contM;
                        double mediaTAmb = zeraJtAmb / contM;
//                        System.out.println("\nMédia T1: " + mediaT1 + "\tMédia T2: " + mediaT2 + "\tMédia T3: " + mediaT3 + "\tMédia TamB: " + mediaTAmb);

                        csvPrinter.printRecord("Janela " + (i + 1), posiInicialList.get(i), posiFinaisList.get(i), df.format(mediaT1), df.format(mediaT2), df.format(mediaT3), df.format(mediaTAmb));

                        contM = 1;
                        zeraJt1 = 0;
                        zeraJt2 = 0;
                        zeraJt3 = 0;
                        zeraJtAmb = 0;
                    }
                }
            }
        } catch (IOException e) {
            log.error("Erro ao escrever CSV", e);
        }
    }

    public void vbaFuncPuro(Writer writer) {
        List<Temperatura> temperaturaList = interface_temperatura.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("Termopar1", "Termopar2", "Termopar3", "TermoparAmb");

            for (Temperatura temperatura : temperaturaList) {
                csvPrinter.printRecord(temperatura.getTermopar1(), temperatura.getTermopar2(), temperatura.getTermopar3(), temperatura.getTempAmb());
            }
        } catch (IOException e) {
            log.error("Erro ao escrever CSV", e);
        }

    }


}

