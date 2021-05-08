package com.sitMauricie.SitMaurice.repository;

import com.sitMauricie.SitMaurice.model.Individu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndividuRepository extends JpaRepository<Individu, Long> {
    List<Individu> findBySexe(boolean sexe);

    List<Individu> findByFnameContaining(String fname);

}
