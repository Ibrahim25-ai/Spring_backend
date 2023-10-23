package com.example.membre.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@DiscriminatorValue("etd")

public class Etudiant extends Membre{
    @ManyToOne
    private EnseignantChercheur encadrant;
    @NonNull
    private Date dateInscription;
    @NonNull
    private String diplome;
    @Builder
    public Etudiant( String cin, String nom, String prenom, Date dateNaissance,
                     String cv,
                     String email, String password, Date dateInscription, String
                             diplome,
                     EnseignantChercheur encadrant) {
        super( cin, nom, prenom, dateNaissance, cv, email, password);
        this.dateInscription = dateInscription;
        this.diplome = diplome;
        this.encadrant = encadrant;
    }
}
