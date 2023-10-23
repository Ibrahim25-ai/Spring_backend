package com.example.membre.dao;

import com.example.membre.entities.Membre;
import com.example.membre.entities.Membre_Pub_Id;
import com.example.membre.entities.Membre_Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;
@RepositoryRestController
public interface MembrePubRepository extends JpaRepository <Membre_Publication, Membre_Pub_Id> {
    List<Membre_Publication> findByAuteur(Membre auteur);
}