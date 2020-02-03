package br.com.compasso.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.compasso.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	@Query("SELECT c FROM City c WHERE c.name = ?1")
	public Set<City> findByName(String name);
	
	@Query("SELECT c FROM City c WHERE c.uf = ?1")
	public Set<City> findByUf(String uf);
}
