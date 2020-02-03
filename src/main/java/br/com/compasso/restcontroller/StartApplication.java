package br.com.compasso.restcontroller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.entity.City;
import br.com.compasso.entity.Customer;
import br.com.compasso.enums.GenderEnum;
import br.com.compasso.request.CityRequest;
import br.com.compasso.request.CustomerRequest;
import br.com.compasso.response.Message;
import br.com.compasso.service.CityService;
import br.com.compasso.service.CustomerService;
/**
 * @author esc_jmelo
 * Serviços criados na mesma classe apenas para demonstração
 * */
@RestController
@RequestMapping("/api/")
@SpringBootApplication
@EntityScan(basePackages = {"br.com.compasso.entity"})
@ComponentScan(basePackages = {"br.com.compasso.service"})
@EnableJpaRepositories(basePackages = {"br.com.compasso.repository"})
public class StartApplication {

	@Autowired
	private CityService cityService;
	
	@Autowired
	private CustomerService customerService;
	
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public Message welcome() {
		return new Message("Welcome to Compasso Microservice!");
	}
	
	/* City CRUD */
	@RequestMapping(value = "/city/save", method = RequestMethod.PUT)
	public Object saveCity(@RequestBody(required = true) CityRequest cityRequest) {		
		try {
				return this.cityService.save(new City(cityRequest.getName(), cityRequest.getUf()));
				
		}catch(DataIntegrityViolationException ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Existing record");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while processing");
		}
	}
	
	@RequestMapping(value = "/city/find/name", method = RequestMethod.GET)
	public Object findCityByName(@RequestParam(name = "name", required = true) String name) {			
		try {
				return this.cityService.findByName(name);
				
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while processing");
		}
	}
	
	@RequestMapping(value = "/city/find/uf", method = RequestMethod.GET)
	public Object findCityByUf(@RequestParam(name = "uf", required = true) String uf) {			
		try {
				return this.cityService.findByUf(uf);	
				
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while processing");
		}
	}
	
	/* Customer CRUD */
	@RequestMapping(value = "/customer/save", method = RequestMethod.PUT)
	public Object saveCustomer(@RequestBody(required = true) CustomerRequest customerRequest) {		
		try {
			return this.customerService.save(new Customer(customerRequest.getName(),
					GenderEnum.valueOf(customerRequest.getGender()), customerRequest.getDateOfBirth(),
					customerRequest.getAge(), cityService.findById(customerRequest.getCity())));
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while processing");
		}
	}
	
	@RequestMapping(value = "/customer/find/name", method = RequestMethod.GET)
	public Object findCustomerByName(@RequestParam(name = "name", required = true) String name) {			
		try {
				return this.customerService.findByName(name);
				
		}catch(NoSuchElementException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not found");
	
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while processing");
		}
	}
	
	@RequestMapping(value = "/customer/find/id", method = RequestMethod.GET)
	public Object findCustomerById(@RequestParam(name = "id", required = true) Long id) {			
		try {
				return this.customerService.findById(id);
				
		}catch(NoSuchElementException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not found");
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while processing");
		}
	}
	
	@RequestMapping(value = "/customer/delete/id", method = RequestMethod.DELETE)
	public Object deleteCustomer(@RequestParam(name = "id", required = true) Long id) {			
		try {
				Customer customer = customerService.findById(id);
				
				if(customer == null) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not found");
				}
			
				this.customerService.remove(customer);
				return new ResponseEntity<Void>(HttpStatus.OK);
				
		}catch(Exception ex) {
			ex.printStackTrace();		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while processing");
		}
	}
}