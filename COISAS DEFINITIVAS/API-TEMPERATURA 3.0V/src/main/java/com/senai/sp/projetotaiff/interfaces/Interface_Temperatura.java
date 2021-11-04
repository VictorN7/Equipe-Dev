package com.senai.sp.projetotaiff.interfaces;

import com.senai.sp.projetotaiff.modal.Temperatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Interface_Temperatura extends JpaRepository<Temperatura, Integer> {

}
