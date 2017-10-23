package com.capgemini.demo.sampledatamanagement.logic.api.to;

import javax.validation.constraints.Size;

import com.capgemini.demo.general.common.api.to.AbstractEto;
import com.capgemini.demo.sampledatamanagement.common.api.SampleData;

/**
 * Entity transport object of SampleData
 */
public class SampleDataEto extends AbstractEto implements SampleData {

	private static final long serialVersionUID = 1L;
	/**
	 * Name string.
	 */
	@Size(max = 100, min = 0)
	private String name;
	/**
	 * Surname string.
	 */
	private String surname;
	/**
	 * Age integer.
	 */
	private Integer age;
	/**
	 * Mail string.
	 */
	private String mail;
	private Long restaurantTableId;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public void setRestaurantTableId(Long restaurantTableId) {
		this.restaurantTableId = restaurantTableId;
	}

	@Override
	public Long getRestaurantTableId() {
		return this.restaurantTableId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.surname == null) ? 0 : this.surname.hashCode());
		result = prime * result + ((this.age == null) ? 0 : this.age.hashCode());
		result = prime * result + ((this.mail == null) ? 0 : this.mail.hashCode());
		result = prime * result + ((this.restaurantTableId == null) ? 0 : this.restaurantTableId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		// class check will be done by super type EntityTo!
		if (!super.equals(obj)) {
			return false;
		}
		SampleDataEto other = (SampleDataEto) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.surname == null) {
			if (other.surname != null) {
				return false;
			}
		} else if (!this.surname.equals(other.surname)) {
			return false;
		}
		if (this.age == null) {
			if (other.age != null) {
				return false;
			}
		} else if (!this.age.equals(other.age)) {
			return false;
		}
		if (this.mail == null) {
			if (other.mail != null) {
				return false;
			}
		} else if (!this.mail.equals(other.mail)) {
			return false;
		}
		if (this.restaurantTableId == null) {
			if (other.restaurantTableId != null) {
				return false;
			}
		} else if (!this.restaurantTableId.equals(other.restaurantTableId)) {
			return false;
		}
		return true;
	}
}
