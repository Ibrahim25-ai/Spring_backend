package com.example.membre;

import com.example.membre.entities.Etudiant;
import com.example.membre.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MembreApplication implements CommandLineRunner {
    @Autowired
    IMemberService memberService;
    public static void main(String[] args) {
        SpringApplication.run(MembreApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Etudiant etd1= Etudiant.builder()
                .cin("123457")
                .dateInscription(new Date())
                .dateNaissance(new Date())
                .diplome("mastère")
                .email("etd1@gmail.com")
                .password("pass1")
                .encadrant(null)
                .cv("cv1")
                .nom("abid")
                .prenom("youssef)")
                .build();
        memberService.addMember(etd1);
    }
}
