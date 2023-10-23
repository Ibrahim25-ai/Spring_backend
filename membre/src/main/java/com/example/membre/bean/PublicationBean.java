package com.example.membre.bean;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
@Data
public class PublicationBean {

    private Long id;

    private String type;
    private String titre;

    private String lien;

    private Date date;

    private String sourcePdf;
}
