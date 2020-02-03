package br.com.compasso.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.entity.City;
import br.com.compasso.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	
	public City save(City city) throws Exception{
		return repository.saveAndFlush(city);
	}
	
	public Set<City> findByName(String name) throws Exception{
		return repository.findByName(name);
	}
	
	public Set<City> findByUf(String uf) throws Exception{
		return repository.findByUf(uf);
	}
	
	public City findById(Long id) throws Exception{
		return repository.findById(id).get();
	}
}