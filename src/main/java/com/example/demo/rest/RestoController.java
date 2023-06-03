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

import com.example.demo.entity.Resto;
import com.example.demo.entity.Ville;
import com.example.demo.service.RestoService;

@RequestMapping("/api/resto")
@RestController
@CrossOrigin("*")

public class RestoController {
	
	@Autowired
	RestoService restoservice;
	
	@PostMapping("/save")
	public Resto save(@RequestBody Resto o) {
		return restoservice.save(o);
	}
	
	@GetMapping("/all") 
	public List<Resto> findall() {
		return restoservice.findall();
	}

	@GetMapping("/findbyid/{id}")
	public Resto findbyid(@PathVariable int id) {
		return restoservice.findbyid(id);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody Resto o) {
		restoservice.delete(o);
	}
	
	@PutMapping("/update")
	public void update(@PathVariable Resto o) {
		restoservice.update(o);
	}
	
	
	@PutMapping("/{id}")
	 public Resto updateResto(@PathVariable int id, @RequestBody Resto resto) {
	        Resto existingVille = restoservice.findbyid(id);
	        if (existingVille != null) {
	            existingVille.setNom(resto.getNom());
	            return restoservice.save(existingVille);
	        }
	        return null;
	    }
	
	@GetMapping("/zones/zone/{nom}")
	public List<Resto> findRestoByNom(@PathVariable String nom) {
		return restoservice.findRestoByNom(nom);
	}
	@GetMapping("/allresto/zone/{zone}/specialite/{spec}")
	public List<Resto> findRestoByZoneAndSpecialite(@PathVariable String zone,@PathVariable String spec) {
		return restoservice.findRestoByZoneAndSpecialite( zone,spec);
	}
	
	@GetMapping("/allresto/zone/{zone}/serie/{serie}")
	public List<Resto> findRestoByZoneAndSerie(@PathVariable String zone,@PathVariable String serie) {
		return restoservice.findRestoByZoneAndSerie(zone, serie);
	}
	
	@GetMapping("/filter/{ville}/{zone}")
	public List<Resto> findRestoByVilleAndZone(@PathVariable String ville,@PathVariable String zone) {
		
		return restoservice.findRestoByVilleAndZone(ville, zone);
	}
	
	@GetMapping("/filter2/{ville}/{zone}/{serie}")
	public List<Resto> findRestoByVilleAndZoneAndSerie(@PathVariable String ville,@PathVariable String zone,@PathVariable String serie) {
		
		return restoservice.findRestoByVilleAndZoneAndSerie(ville,zone, serie);
	}
	
}
