package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Specialite;
import com.example.demo.entity.Ville;
import com.example.demo.service.VilleService;

@RequestMapping("/api/villes")
@RestController
@CrossOrigin("*")

public class VilleControlleur {
		
	@Autowired
	public VilleService villeservice;
	
	@PostMapping("/save")
	public Ville save(@RequestBody Ville o) {
		return villeservice.save(o);
	}
	
	@GetMapping("/")
	public List<Ville> findall() {
		return villeservice.findall();
	}
	@GetMapping("/findbyid/{id}")
	public Ville findbyid(@PathVariable int id) {
		return villeservice.findbyid(id);
	}
	/*@DeleteMapping("/delete")
	public void delete(@RequestBody Ville o) {
		villeservice.delete(o);
	}*/
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		villeservice.delete(id);
	}
	
	/*@PutMapping("/update/{id}")
	public void update(@PathVariable Ville o) {
		villeservice.save(o);
	}*/
	
	
	@PutMapping("/{id}")
	 public Ville updateVille(@PathVariable int id, @RequestBody Ville ville) {
	        Ville existingVille = villeservice.findbyid(id);
	        if (existingVille != null) {
	            existingVille.setNom(ville.getNom());
	            return villeservice.save(existingVille);
	        }
	        return null;
	    }
	
	
	
}
