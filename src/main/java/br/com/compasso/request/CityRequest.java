package br.com.compasso.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CityRequest {

	@NotEmpty(message = "Name may not be empty")
	@NotBlank(message = "Name may not be blank")
	private String name;
	
	@NotEmpty(message = "UF may not be empty")
	@NotBlank(message = "UF may not be blank")
	private String uf;
	
	/**
	 * 
	 */
	public CityRequest() {
		super();
	}

	/**
	 * @param name
	 * @param uf
	 */
	public CityRequest(
			@NotEmpty(message = "Name may not be empty") @NotBlank(message = "Name may not be blank") String name,
			@NotEmpty(message = "UF may not be empty") @NotBlank(message = "UF may not be blank") String uf) {
		this.name = name;
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "CityRequest [name=" + name + ", uf=" + uf + "]";
	}
}