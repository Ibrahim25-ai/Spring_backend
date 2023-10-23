package com.example.outil.controleur;


import com.example.outil.entities.Outil;
import com.example.outil.service.IOutilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OutilRestController {
    @Autowired
    IOutilService outilService;

    @RequestMapping(value = "/outils", method = RequestMethod.GET)
    public List<Outil> findOutils() {
        return outilService.findAll();
    }

    @GetMapping(value = "/outils/{id}")
    public Outil findoutilById(@PathVariable Long id) {
        return outilService.findOutil(id);
    }

    @GetMapping(value = "/outils/search/titre")
    public List<Outil> findoutilBySource(@RequestParam String source) {
        return outilService.findBySource(source);
    }

    @PostMapping(value = "/outil/add")
    public Outil addoutil(@RequestBody Outil e) {
        return outilService.addOutil(e);
    }

    @PutMapping(value = "/outil/update/{id}")
    public Outil updateoutil(@PathVariable Long id, @RequestBody
    Outil e) {

        e.setId(id);
        return outilService.updateOutil(e);

    }
}
