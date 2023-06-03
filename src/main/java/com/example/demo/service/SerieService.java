package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.SerieRepository;
import com.example.demo.entity.Serie;
import com.example.demo.idao.IDao;

@Service
public class SerieService implements IDao<Serie>{
	
	@Autowired
	SerieRepository serieRepository;

	@Override
	public Serie save(Serie o) {
		// TODO Auto-generated method stub
		return serieRepository.save(o);
	}

	@Override
	public List<Serie> findall() {
		// TODO Auto-generated method stub
		return serieRepository.findAll();
	}

	@Override
	public Serie findbyid(int id) {
		// TODO Auto-generated method stub
		return serieRepository.findById(id).get();
	}

	@Override
	public void delete(Serie o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Serie o) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		serieRepository.deleteById(id);
		
	}
}
