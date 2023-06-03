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
public class VilleService implements IDao<Ville>{
	@Autowired
	public VilleRepository villerepository;
	@Autowired
	public ZoneRepository zonerepository;
	@Override
	public Ville save(Ville o) {
		return villerepository.save(o);
	}

	@Override
	public List<Ville> findall() {
		return villerepository.findAll();
	}

	@Override
	public Ville findbyid(int id) {
		return villerepository.findById(id).get();
	}

	@Override
	public void delete(Ville o) {
		
		villerepository.delete(o);		
	}

	@Override
	public void update(Ville o) {
		villerepository.save(o);	
	}

	public Ville findByNom(String nom) {
		return villerepository.findByNom(nom);
	}
	public void delete(int id) {
		List<Zone> z1 =zonerepository.findByVilleId(id);
		for (Zone z : z1) {
			
			zonerepository.delete(z);
		}		villerepository.deleteById(id);
		
	}
	
	

}
