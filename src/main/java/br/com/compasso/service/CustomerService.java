package br.com.compasso.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.entity.Customer;
import br.com.compasso.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	public Customer save(Customer customer) throws Exception{
		return repository.saveAndFlush(customer);
	}
	
	public Set<Customer> findByName(String name) throws Exception{
		return repository.findByName(name);
	}
	
	public Customer findById(Long id) throws Exception{
		return repository.findById(id).get();
	}
	
	public void remove(Customer customer) throws Exception{
		repository.delete(customer);
	}
}