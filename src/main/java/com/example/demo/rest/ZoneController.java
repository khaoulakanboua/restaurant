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

import com.example.demo.entity.Zone;
import com.example.demo.service.ZoneService;

@RequestMapping("/api/zones")
@RestController
public class ZoneController {
	@Autowired
	ZoneService zoneservice;
	
	@PostMapping("/save")
	public Zone save(@RequestBody Zone o) {
		return zoneservice.save(o);
	}
	@GetMapping("/")
	public List<Zone> findall() {
		return zoneservice.findall();
	}
	
	@GetMapping("/findbyid/{id}")
	public Zone findbyid(@PathVariable int id) {
		return zoneservice.findbyid(id);
	}
	@DeleteMapping("/delete")
	public void delete(@RequestBody Zone o) {
		zoneservice.delete(o);
	}
	@PutMapping("/update/{id}")
	public void update(@PathVariable Zone o) {
		zoneservice.save(o);
	}
	@GetMapping("/ville/zones/{nom}")
	public List<Zone> findVilleByNom(@PathVariable String nom) {
		return zoneservice.findVilleByNom(nom);
	}
	
	
}