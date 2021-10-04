package com.senai.sp.projetotaiff.modal;


import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Temperatura")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Temperatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_temperatura;

    @Column(nullable = false)
    private double termopar1;

    @Column(nullable = false)
    private double termopar2;

    @Column(nullable = false)
    private double termopar3;

    @Column(nullable = false)
    private double tempAmb;

    @Column(nullable = false)
    private LocalDate data_leitura;

    @Column(nullable = false)
    private int id_posicao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Temperatura that = (Temperatura) o;
        return Objects.equals(id_temperatura, that.id_temperatura);
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
