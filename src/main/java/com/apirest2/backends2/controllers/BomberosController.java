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
public class BomberosController {
    
    @Autowired
    private BomberRepository bomberoRepository;

    @GetMapping
    public List<Bomber> obtenerTodosLosBomberos() {
        return bomberoRepository.findAll();
    }

    @GetMapping("/{bomberoId}")
    public ResponseEntity<Bomber> obtenerBomberoPorId(@PathVariable Long bomberoId) {
        Bomber bombero = bomberoRepository.findById(bomberoId).orElse(null);
        if (bombero != null) {
            return ResponseEntity.ok(bombero);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Bomber crearBombero(@RequestBody Bomber nuevoBombero) {
        return bomberoRepository.save(nuevoBombero);
    }

    @PutMapping("/{bomberoId}")
    public Bomber actualizarBombero(@PathVariable Long bomberoId, @RequestBody Bomber bombero){
        bombero.setId(bomberoId);
        return bomberoRepository.save(bombero);
    }

    @DeleteMapping("/{bomberoId}")
    public void borrarBombero(@PathVariable Long bomberoId ){
        bomberoRepository.deleteById(bomberoId);
    }
}