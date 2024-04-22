package com.apirest2.backends2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest2.backends2.models.Bombero; 


public interface BomberoRepository extends JpaRepository<Bombero, Long>{  
    List<Bombero> findByCodigo(String codigo);
}