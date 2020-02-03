package br.com.compasso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CITY", uniqueConstraints={@UniqueConstraint(columnNames = {"name", "uf"})})
public class City extends GenericEntity{
	
	@Column(name = "NAME", nullable = false, length = 150)
	private String name;
	
	@Column(name = "UF", nullable = false, length = 2)
	private String uf;

	/**
	 * 
	 */
	public City() {
		super();
	}

	/**
	 * @param name
	 * @param uf
	 */
	public City(String name, String uf) {
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
		return "City [name=" + name + ", uf=" + uf + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}