package com.example.outil.dao;

import com.example.outil.entities.Outil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OutilRepository extends JpaRepository<Outil,Long> {
    List<Outil> findBySource(String source);
    List<Outil> findByDate(Date date);


}
