package br.com.compasso.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.compasso.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query("SELECT c FROM Customer c WHERE c.name = ?1")
	public Set<Customer> findByName(String name);
}
