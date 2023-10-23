package com.example.outil.service;

import com.example.outil.entities.Outil;

import java.util.Date;
import java.util.List;

public interface IOutilService {
    //Crud sur les outils
    public Outil addOutil(Outil m);
    public void deleteOutil(Long id) ;
    public Outil updateOutil(Outil p) ;
    public Outil findOutil(Long id) ;
    public List<Outil> findAll();
    //Filtrage par propriété
    public List<Outil> findByDate(Date date);
    public List<Outil> findBySource(String source);

//other ...
}