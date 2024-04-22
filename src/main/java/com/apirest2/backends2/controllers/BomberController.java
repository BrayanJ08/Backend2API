package com.apirest2.backends2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest2.backends2.models.Bomber;
import com.apirest2.backends2.repositories.BomberRepository;

@RestController
@RequestMapping("/clients")
public class BomberController extends BaseController{
    
    @Autowired
    private BomberRepository bomberoRepository;

    @GetMapping
    public List<Bomber> getAllClients() {
        return bomberoRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Bomber> getById(@PathVariable Long clientId) {
        Bomber bomberos = bomberoRepository.findById(clientId).orElse(null);
        if (bomberos != null) {
            return ResponseEntity.ok(bomberos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Bomber createClient(@RequestBody Bomber bomberos) {
        return bomberoRepository.save(bomberos);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Bomber> updateClientById(@PathVariable Long clientId, @RequestBody Bomber bomberos){
        bomberos.setId(clientId);
        Bomber updatedBomberos = bomberoRepository.save(bomberos);
        if (updatedBomberos != null) {
            return ResponseEntity.ok(updatedBomberos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClientById(@PathVariable Long clientId){
        bomberoRepository.deleteById(clientId);
        return ResponseEntity.noContent().build();
    }
}