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

import com.example.demo.entity.Specialite;
import com.example.demo.service.SpecialiteService;

@RequestMapping("/api/specialite")
@RestController
public class SpecialiteController {
		@Autowired
		SpecialiteService specialiteService;

		@PostMapping("/save")
		public Specialite save(@RequestBody Specialite o) {
			return specialiteService.save(o);
		}
		
		@GetMapping("/all")
		public List<Specialite> findall() {
			return specialiteService.findall();
		}
		
		@GetMapping("findbyid/{id}")
		public Specialite findbyid(@PathVariable int id) {
			return specialiteService.findbyid(id);
		}
		@DeleteMapping("/delete/{id}")
		public void delete(@PathVariable int id) {
			specialiteService.delete(id);
		}
		@PutMapping("/update")
		public void update(@RequestBody Specialite o) {
			specialiteService.update(o);
		}
	
		
		@PutMapping("/{id}")
		 public Specialite updateSpecialite(@PathVariable int id, @RequestBody Specialite specialite) {
		        Specialite existingSpecialite = specialiteService.findbyid(id);
		        if (existingSpecialite != null) {
		            existingSpecialite.setNom(specialite.getNom());
		            return specialiteService.save(existingSpecialite);
		        }
		        return null;
		    }	
}
