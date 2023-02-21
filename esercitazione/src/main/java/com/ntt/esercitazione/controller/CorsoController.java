package com.ntt.esercitazione.controller;

import com.ntt.esercitazione.domain.Corso;
import com.ntt.esercitazione.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CorsoController {

    @Autowired
    CorsoRepository corsoRepository;


    @PostMapping("/corso")
    public ResponseEntity<Corso> create(@RequestBody Corso corso) {
        Corso corso1 = corsoRepository.save(corso);
        return new ResponseEntity<>(corso1, HttpStatus.CREATED);
    }

    @GetMapping("/corso")
    public ResponseEntity<List<Corso>> findAll() {
        List<Corso> corsoList = corsoRepository.findAll();
        return new ResponseEntity<List<Corso>>(corsoList, HttpStatus.OK);
    }

    @PutMapping("/corso/{id}")
    public ResponseEntity<Corso> updateCorso(@PathVariable long id, @RequestBody Corso corso) {
        Corso corso2 = corsoRepository.save(corso);
        if (corso2.getId() == id)
            return new ResponseEntity<>(corso2, HttpStatus.CREATED);
        return new ResponseEntity<>(corso2, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/corso/{id}")
    public ResponseEntity<?> deleteCorso(@PathVariable long id) {
        corsoRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/corso/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable("id") long id, @RequestBody Corso corso) {
        List<Corso> lista = corsoRepository.findAll();
        boolean b = false;
        for (Corso c : lista) {
            if (c.getId() == corso.getId()) {
                b = true;
            }
        }
        if (b) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            Corso corso1 = corsoRepository.save(corso);
            return new ResponseEntity<>(corso1, HttpStatus.CREATED);
        }

    }

    @PostMapping("/prefisso")
    public ResponseEntity<?> createCorso1(@RequestBody Corso corso) {
        if (corso.getNome().substring(0, 6).equals("corso_") && corso.getNome().length() >= 8) {
            Corso corso1 = corsoRepository.save(corso);
            return new ResponseEntity<>(corso1, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Nome errato", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/view")
    public ResponseEntity<?> viewAll() {
        List<Corso> corsi = corsoRepository.findAll();
        return new ResponseEntity<>(corsi, HttpStatus.OK);
    }

    @GetMapping("/checkNum")
    public ResponseEntity<?> getNum() {
        List<Corso> list = corsoRepository.findAll();
        int i = list.size();
        return new ResponseEntity<>(i , HttpStatus.OK);
    }

    @GetMapping("/corsi_")
    public ResponseEntity<?> getCorsi(){
        List<Corso> corsi = corsoRepository.findAll();
        int conta = 0;
        for(Corso c : corsi){
            if(c.getNome().substring(0,6).equals("corso_")){
                conta++;
            }
        }
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }

    @GetMapping("/descrizione")
    public ResponseEntity<?> getCorsi1() {
        List<Corso> corsi = corsoRepository.findAll();
        List<Corso> corsi1 = new ArrayList<>();
        int i = 0;
        for(Corso corso: corsi){
            if(corso.getDescrizione().length() > 20){
                corsi1.add(corso);
            }
        }
        return new ResponseEntity<>(corsi1 , HttpStatus.OK);
    }

}