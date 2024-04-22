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
@RequestMapping("/bomberos")
public class BomberoController {
    
    @Autowired
    private BomberRepository bomberoRepository;

    @GetMapping
    public List<Bomber> obtenerTodosLosBomberos() {
        return bomberoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bomber> obtenerBomberosPorId(@PathVariable Long id) {
        Bomber bomberos = bomberoRepository.findById(id).orElse(null);
        if (bomberos != null) {
            return ResponseEntity.ok(bomberos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Bomber crearBomberos(@RequestBody Bomber bomberos) {
        return bomberoRepository.save(bomberos);
    }

    @PutMapping("/{id}")
    public Bomber actualizarBomberos(@PathVariable Long id, @RequestBody Bomber bomberos){
        bomberos.setId(id);
        return bomberoRepository.save(bomberos);
    }

    @DeleteMapping("/{id}")
    public void borrarBomberos(@PathVariable Long id ){
        bomberoRepository.deleteById(id);
    }
}