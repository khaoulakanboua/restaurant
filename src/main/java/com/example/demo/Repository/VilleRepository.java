package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer>{
		Ville findByNom(String nom);
}
