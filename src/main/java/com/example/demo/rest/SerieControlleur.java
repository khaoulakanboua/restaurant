package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Serie;
import com.example.demo.service.SerieService;

@RequestMapping("/api/series")
@RestController
public class SerieControlleur {
	
	@Autowired
	SerieService serieService;
	
	
	@PostMapping("/save")
	public Serie save(@RequestBody Serie o) {
		return serieService.save(o);
	}

	@GetMapping("/all")
	public List<Serie> findall() {
		return serieService.findall();
	}


	@GetMapping("/findbyid/{id}")
	public Serie findbyid(@PathVariable int id) {
		return serieService.findbyid(id);
	}


	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		serieService.delete(id);
	}



	@PutMapping("/{id}")
	 public Serie updateVille(@PathVariable int id, @RequestBody Serie serie) {
	        Serie existingSerie = serieService.findbyid(id);
	        if (existingSerie != null) {
	            existingSerie.setNom(serie.getNom());
	            return serieService.save(existingSerie);
	        }
	        return null;
	    }
	
}
