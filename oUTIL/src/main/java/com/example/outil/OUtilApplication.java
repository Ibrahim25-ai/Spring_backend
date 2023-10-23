package com.example.outil;

import com.example.outil.entities.Outil;
import com.example.outil.service.IOutilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class OUtilApplication  {
    public static void main(String[] args) {
        SpringApplication.run(OUtilApplication.class, args);
    }
}
