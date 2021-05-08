package com.sitMauricie.SitMaurice.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sitMauricie.SitMaurice.model.Individu;
import com.sitMauricie.SitMaurice.repository.IndividuRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class IndividuController {

    @Autowired
    IndividuRepository individuRepository;

    @GetMapping("/individus")
    public ResponseEntity<List<Individu>> getAllIndividus(@RequestParam(required = false) String fname) {
        try {
            List<Individu> individus = new ArrayList<Individu>();

            if (fname == null)
                individuRepository.findAll().forEach(individus::add);
            else
                individuRepository.findByFnameContaining(fname).forEach(individus::add);

            if (individus.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(individus, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/individus/{id}")
    public ResponseEntity<Individu> getIndividuById(@PathVariable("id") long id) {
        Optional<Individu> individuData = individuRepository.findById(id);

        if (individuData.isPresent()) {
            return new ResponseEntity<>(individuData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/individus")
    public ResponseEntity<Individu> createIndividu(@RequestBody Individu individu) {
        try {
            Individu _individu = individuRepository
                    .save(new Individu(individu.getFname(), individu.getLname(), false));
            return new ResponseEntity<>(_individu, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/individus{id}")
    public ResponseEntity<Individu> updateIndividu(@PathVariable("id") long id, @RequestBody Individu individu) {
        Optional<Individu> individuData = individuRepository.findById(id);

        if (individuData.isPresent()) {
            Individu _individu = individuData.get();
            _individu.setFname(individu.getFname());
            _individu.setLname(individu.getLname());
            _individu.setSexe(individu.isMale());
            return new ResponseEntity<>(individuRepository.save(_individu), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/individus{id}")
    public ResponseEntity<HttpStatus> deleteIndividu(@PathVariable("id") long id) {
        try {
            individuRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/individus")
    public ResponseEntity<HttpStatus> deleteAllIndividus() {
        try {
            individuRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/individusdefined")
    public ResponseEntity<List<Individu>> findBySexe() {
        try {
            List<Individu> individus = individuRepository.findBySexe(true);

            if (individus.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(individus, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}








