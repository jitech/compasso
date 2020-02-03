package br.com.compasso.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CustomerRequest {

	private Long id;
	
	@NotEmpty(message = "Name may not be empty")
	@NotBlank(message = "Name may not be blank")
	private String name;
	
	@NotEmpty(message = "Gender may not be empty")
	@NotBlank(message = "Gender may not be blank")
	private String gender;
	
	@NotEmpty(message = "Date of Birth may not be empty")
	@NotBlank(message = "Date of Birth may not be blank")
	private Date dateOfBirth;
	
	@NotEmpty(message = "Age may not be empty")
	@NotBlank(message = "Age may not be blank")
	private int age;
	
	@NotEmpty(message = "City may not be empty")
	@NotBlank(message = "City may not be blank")
	private Long city;
	
	/**
	 * 
	 */
	public CustomerRequest() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param gender
	 * @param dateOfBirth
	 * @param age
	 * @param city
	 */
	public CustomerRequest(Long id,
			@NotEmpty(message = "Name may not be empty") @NotBlank(message = "Name may not be blank") String name,
			@NotEmpty(message = "Gender may not be empty") @NotBlank(message = "Gender may not be blank") String gender,
			@NotEmpty(message = "Date of Birth may not be empty") @NotBlank(message = "Date of Birth may not be blank") Date dateOfBirth,
			@NotEmpty(message = "Age may not be empty") @NotBlank(message = "Age may not be blank") int age,
			@NotEmpty(message = "City may not be empty") @NotBlank(message = "City may not be blank") Long city) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.city = city;
	}

	/**
	 * @param name
	 * @param gender
	 * @param dateOfBirth
	 * @param age
	 * @param city
	 */
	public CustomerRequest(
			@NotEmpty(message = "Name may not be empty") @NotBlank(message = "Name may not be blank") String name,
			@NotEmpty(message = "Gender may not be empty") @NotBlank(message = "Gender may not be blank") String gender,
			@NotEmpty(message = "Date of Birth may not be empty") @NotBlank(message = "Date of Birth may not be blank") Date dateOfBirth,
			@NotEmpty(message = "Age may not be empty") @NotBlank(message = "Age may not be blank") int age,
			@NotEmpty(message = "City may not be empty") @NotBlank(message = "City may not be blank") Long city) {
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.city = city;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getCity() {
		return city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CustomerRequest [id=" + id + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", age=" + age + ", city=" + city + "]";
	}
}