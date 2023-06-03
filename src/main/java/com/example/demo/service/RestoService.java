package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.RestoRepository;
import com.example.demo.Repository.ZoneRepository;
import com.example.demo.entity.Resto;
import com.example.demo.entity.Zone;
import com.example.demo.idao.IDao;

@Service
public class RestoService implements IDao<Resto>{

	@Autowired
	public RestoRepository restorepository;
	
	@Autowired
	public ZoneRepository zonerepository;
	
	@Override
	public Resto save(Resto o) {
		return restorepository.save(o);
	}

	@Override
	public List<Resto> findall() {
		// TODO Auto-generated method stub
		return restorepository.findAll();
	}

	@Override
	public Resto findbyid(int id) {
		return restorepository.findById(id).get();
	}

	@Override
	public void delete(Resto o) {
		// TODO Auto-generated method stub
		restorepository.delete(o);
	}

	@Override
	public void update(Resto o) {
		// TODO Auto-generated method stub
		restorepository.save(o);
	}
	
	public List<Resto> findRestoByNom(String nom) {
		Zone zone=zonerepository.findByNom(nom);
		return zone.getResto();
	}

	public List<Resto> findRestoByZoneAndSpecialite(String zone, String spec) {
		return restorepository.findRestoByZoneAndSpecialite(zone, spec);
	}

	public List<Resto> findRestoByZoneAndSerie(String zone, String serie) {
		return restorepository.findRestoByZoneAndSerie(zone, serie);
	}
	
	public List<Resto> findRestoByVilleAndZone(String ville, String zone) {
		
		return restorepository.findRestoByVilleAndZone(ville, zone);
	}
	
	public List<Resto> findRestoByVilleAndZoneAndSerie(String ville, String zone,String serie) {
		
		return restorepository.findRestoByVilleAndZoneAndSerie(ville, zone,serie);
	}
	

}
