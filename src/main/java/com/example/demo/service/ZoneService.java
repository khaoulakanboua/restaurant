package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.VilleRepository;
import com.example.demo.Repository.ZoneRepository;
import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
import com.example.demo.idao.IDao;

@Service
public class ZoneService implements IDao<Zone>{

	@Autowired
	ZoneRepository zonerepository;
	@Autowired
	VilleRepository villerepository;
	@Override
	public Zone save(Zone o) {
		// TODO Auto-generated method stub
		return zonerepository.save(o);
	}

	@Override
	public List<Zone> findall() {
		// TODO Auto-generated method stub
		return zonerepository.findAll();
	}

	@Override
	public Zone findbyid(int id) {
		// TODO Auto-generated method stub
		return zonerepository.findById(id).get();
	}

	@Override
	public void delete(Zone o) {
		zonerepository.delete(o);		
	}

	@Override
	public void update(Zone o) {
		zonerepository.save(o);		
	}

	public List<Zone> findVilleByNom(String nom) {
		Ville ville=villerepository.findByNom(nom);
		return ville.getZone();
	}

	public Zone findByNom(String nom) {
		return zonerepository.findByNom(nom);
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		zonerepository.deleteById(id);
		
	}

	
	
}
