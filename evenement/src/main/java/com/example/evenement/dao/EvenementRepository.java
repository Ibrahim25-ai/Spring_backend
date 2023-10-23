package com.example.evenement.dao;

import com.example.evenement.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface EvenementRepository extends JpaRepository<Evenement,Long>
{
    List<Evenement> findByTitre(String titre);
    List<Evenement> findBytitreStartingWith(String caractere);

    List<Evenement> findByLieu(String lieu);
}