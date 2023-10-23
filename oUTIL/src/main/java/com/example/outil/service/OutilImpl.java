package com.example.outil.service;

import com.example.outil.dao.OutilRepository;
import com.example.outil.entities.Outil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OutilImpl implements IOutilService {
    @Autowired
    OutilRepository outilRepository;

    public Outil addOutil(Outil m) {
        outilRepository.save(m);
        return m;
    }

    public void deleteOutil(Long id) {
        outilRepository.deleteById(id);
    }

    public Outil updateOutil(Outil m) {
        return outilRepository.saveAndFlush(m);
    }

    public Outil findOutil(Long id) {
        Outil m = (Outil) outilRepository.findById(id).get();
        return m;
    }

    public List<Outil> findAll() {
        return outilRepository.findAll();
    }

    public List<Outil> findByDate(Date date) {
        return outilRepository.findByDate(date);
    }

    public List<Outil> findBySource(String source) {
        return outilRepository.findBySource(source);
    }
}