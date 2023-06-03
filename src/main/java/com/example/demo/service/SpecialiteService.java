package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Repository.SpecialiteRepository;
import com.example.demo.entity.Specialite;
import com.example.demo.idao.IDao;



@Service
public class SpecialiteService implements IDao<Specialite>{
	@Autowired
	SpecialiteRepository specialiteRepository;

	@Override
	public Specialite save(Specialite o) {
		// TODO Auto-generated method stub
		return specialiteRepository.save(o);
	}

	@Override
	public List<Specialite> findall() {
		// TODO Auto-generated method stub
		return specialiteRepository.findAll();
	}

	@Override
	public Specialite findbyid(int id) {
		// TODO Auto-generated method stub
		return specialiteRepository.findById(id).get();
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		specialiteRepository.deleteById(id);;
		
	}
	
	@Override
	public void update(Specialite o) {
		// TODO Auto-generated method stub
		specialiteRepository.save(o);
	}

	@Override
	public void delete(Specialite o) {
		// TODO Auto-generated method stub
		
	}

}
