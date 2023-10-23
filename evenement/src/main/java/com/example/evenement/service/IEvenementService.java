package com.example.evenement.service;

import com.example.evenement.entities.Evenement;

import java.util.List;

public interface IEvenementService {
    //Crud sur les evenements
    public Evenement addEvenement(Evenement m);
    public void deleteEvenement(Long id) ;
    public Evenement updateEvenement(Evenement p) ;
    public Evenement findEvenement(Long id) ;
    public List<Evenement> findAll();
  
    public List<Evenement> findByLieu(String lieu);


    List<Evenement> findBytitre(String titre);
}
