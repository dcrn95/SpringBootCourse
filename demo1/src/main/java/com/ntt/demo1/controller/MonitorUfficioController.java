package com.ntt.demo1.controller;

import com.ntt.demo1.domain.MonitorUfficio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/monitorUfficio")
public class MonitorUfficioController {

    @GetMapping("/")
    public ResponseEntity<MonitorUfficio> returnMonitorUfficio(){
        MonitorUfficio monitorUfficio = new MonitorUfficio();
        Set<String> inputs = new HashSet<>();
        inputs.add("hdmi");
        monitorUfficio.setInput("avg");
        monitorUfficio.setColore("Nero");
        monitorUfficio.setMarca("Lg");
        monitorUfficio.setInputs(inputs);
        return new ResponseEntity<>(monitorUfficio, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createMonitorUfficio(@RequestBody MonitorUfficio monitorUfficio){
        MonitorUfficio monitorUfficio1 = monitorUfficio;
        return new ResponseEntity<>(monitorUfficio1, HttpStatus.CREATED);
    }

    @PutMapping("/{marca}")
    public ResponseEntity<?> updateMonitorUfficio(@PathVariable String marca, @RequestBody MonitorUfficio monitorUfficio){
        MonitorUfficio monitorUfficio1 = new MonitorUfficio();
        Set<String> inputs = new HashSet<>();
        inputs.add("hdmi");
        monitorUfficio1.setInput("avg");
        monitorUfficio1.setColore("Blu");
        monitorUfficio1.setMarca("Lg");
        monitorUfficio1.setInputs(inputs);
        if (monitorUfficio1.getMarca().equals(marca))
            return new ResponseEntity<>(monitorUfficio, HttpStatus.OK);
        return new ResponseEntity<>(monitorUfficio, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{marca}")
    public ResponseEntity<?> deleteMonitorUfficio(@PathVariable String marca){
        System.out.println("Il Monitor Ufficio che è stato eliminato è: " + marca);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
