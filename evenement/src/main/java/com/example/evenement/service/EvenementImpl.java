package com.example.evenement.service;

import com.example.evenement.dao.EvenementRepository;
import com.example.evenement.entities.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EvenementImpl implements IEvenementService {
    @Autowired
    EvenementRepository evenementRepository;

    public Evenement addEvenement(Evenement m) {
        evenementRepository.save(m);
        return m;
    }

    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }

    public Evenement updateEvenement(Evenement m) {
        return evenementRepository.saveAndFlush(m);
    }

    public Evenement findEvenement(Long id) {
        Evenement m = (Evenement) evenementRepository.findById(id).get();
        return m;
    }


    public List<Evenement> findAll() {
        return evenementRepository.findAll();}


    public List<Evenement> findBytitre(String titre) {
        return evenementRepository.findByTitre(titre);
    }


    public List<Evenement> findByLieu(String lieu) {
        return evenementRepository.findByLieu(lieu);
    }

}