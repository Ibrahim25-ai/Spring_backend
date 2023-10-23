package com.example.membre.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@DiscriminatorValue("ens")

public class EnseignantChercheur extends Membre{
    @NonNull
    private String grade;
    @NonNull
    private String etablissement;
    @Builder
    public EnseignantChercheur( String cin, String nom, String prenom, Date dateNaissance,
                     String cv,
                     String email, String password, String grade, String
                                            etablissement) {
        super( cin, nom, prenom, dateNaissance, cv, email, password);
        this.grade = grade;
        this.etablissement = etablissement;
    }
}