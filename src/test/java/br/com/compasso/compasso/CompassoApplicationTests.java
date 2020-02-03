package br.com.compasso.compasso;

import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.compasso.request.CityRequest;
import br.com.compasso.request.CustomerRequest;
import br.com.compasso.restcontroller.StartApplication;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes=StartApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class CompassoApplicationTests {

	/*
	 * Apenas alguns cenários
	 * */
	
	@LocalServerPort
    private int randomServerPort;
	
	@Autowired
	private StartApplication startApplication;
	
	@Test
	@DisplayName("Cadastrando uma cidade")  
	public void createCityTest() {		
		Assert.assertNotNull(startApplication.saveCity(new CityRequest("São Paulo", "SP")));
	}
	
	@Test
	@DisplayName("Selecionando uma cidade")  
	public void findCityTest() {		
		Assert.assertNotNull(startApplication.saveCity(new CityRequest("São Paulo", "SP")));		
		Assert.assertNotNull(startApplication.findCityByName("São Paulo"));
	}
	
	@Test
	@DisplayName("Cadastrando um Cliente")  
	public void createCustomerTest() {
		Assert.assertNotNull(startApplication.saveCity(new CityRequest("São Paulo", "SP")));		
		Assert.assertNotNull(startApplication.saveCustomer(new CustomerRequest("Jonas Goulart", "M", new Date(), 31, 1L)));
	}
	
	@Test
	@DisplayName("Alterando dados de um Cliente")  
	public void updateCustomerTest() {
		Assert.assertNotNull(startApplication.saveCity(new CityRequest("São Paulo", "SP")));		
		Assert.assertNotNull(startApplication.saveCustomer(new CustomerRequest("Jonas Goulart", "M", new Date(), 31, 1L)));
		Assert.assertNotNull(startApplication.saveCustomer(new CustomerRequest(2L, "Jonas Goulart", "M", new Date(), 30, 1L)));
	}
	
	@Test
	@DisplayName("Excluindo dados de um Cliente")  
	public void deleteCustomerTest() {
		Assert.assertNotNull(startApplication.saveCity(new CityRequest("São Paulo", "SP")));		
		Assert.assertNotNull(startApplication.saveCustomer(new CustomerRequest("Jonas Goulart", "M", new Date(), 31, 1L)));
		Assert.assertEquals(new ResponseEntity<Void>(HttpStatus.OK), startApplication.deleteCustomer(2L));
	}
}