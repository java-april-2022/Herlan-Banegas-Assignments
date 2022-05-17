package com.example.dojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojo.models.Dojo;
import com.example.dojo.models.Ninja;
import com.example.dojo.repositories.DojoRepository;
import com.example.dojo.repositories.NinjaRepository;

@Service
public class DojoService {
	
	
	@Autowired
	private DojoRepository dojoRepo;
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	
	//All Ninjas
	public List<Ninja> getAllNinjas(){
		return ninjaRepo.findAll();
	}
	
	//Create Ninjas
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	//All Dojos
	
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	//Create Dojos
	
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	//All Ninjas from One Dojo 
	public List<Ninja> getAll(){
		return ninjaRepo.findAll();
	}
	
	public Dojo getOne(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
}
