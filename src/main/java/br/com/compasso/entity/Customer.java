package br.com.compasso.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.compasso.enums.GenderEnum;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends GenericEntity{

	@Column(name = "NAME", nullable = false, length = 150)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name="GENDER", nullable = false)
	private GenderEnum gender = GenderEnum.M;
	
	@Column(name="DATE_OF_BIRTH", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column(name = "AGE", nullable = false)
	private int age;
	
	@ManyToOne(fetch=FetchType.EAGER, optional = false)
	@JoinColumn(name="CITY_ID")
	private City cityLive;

	
	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @param name
	 * @param gender
	 * @param dateOfBirth
	 * @param age
	 * @param cityLive
	 */
	public Customer(String name, GenderEnum gender, Date dateOfBirth, int age, City cityLive) {
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.cityLive = cityLive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
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

	public City getCityLive() {
		return cityLive;
	}

	public void setCityLive(City cityLive) {
		this.cityLive = cityLive;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", age=" + age
				+ ", cityLive=" + cityLive + "]";
	}
}