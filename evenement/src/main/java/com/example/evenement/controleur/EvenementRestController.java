package com.example.evenement.controleur;

import com.example.evenement.entities.Evenement;
import com.example.evenement.service.IEvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvenementRestController {
    @Autowired
    IEvenementService evenementService;

    @RequestMapping(value = "/evenements", method = RequestMethod.GET)
    public List<Evenement> findEvenement() {
        return evenementService.findAll();
    }

    @GetMapping(value = "/evenements/{id}")
    public Evenement findEventById(@PathVariable Long id) {
        return evenementService.findEvenement(id);
    }

    @GetMapping(value = "/evenements/search/titre")
    public List<Evenement> findEventByTitre(@RequestParam String titre) {
        return evenementService.findBytitre(titre);
    }

    @PostMapping(value = "/evenements/add")
    public Evenement addEvenement(@RequestBody Evenement e) {
        return evenementService.addEvenement(e);
    }

    @PutMapping(value = "/evenements/update/{id}")
    public Evenement updateEvent(@PathVariable Long id, @RequestBody
    Evenement e) {

        e.setId(id);
        return evenementService.updateEvenement(e);

    }
}
