package com.capgemini.demo.sampledatamanagement.dataaccess.api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.capgemini.demo.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.demo.sampledatamanagement.common.api.SampleData;

/**
 * Data access object for SampleData entities
 */
@Entity
@javax.persistence.Table(name = "SampleData")
public class SampleDataEntity extends ApplicationPersistenceEntity implements SampleData {

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

	private List<Long> collection;

	private RestaurantTableEntity restaurantTable;

	private List<RestaurantTableEntity> restaurantTables;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String getSurname() {
		return this.surname;
	}

	@Override
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public Integer getAge() {
		return this.age;
	}

	@Override
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String getMail() {
		return this.mail;
	}

	public void setCollection(List<Long> collection) {
		this.collection = collection;
	}

	public List<Long> getCollection() {
		return this.collection;
	}

	@Override
	@Transient
	public Long getRestaurantTableId() {

		if (this.restaurantTable == null) {
			return null;
		}
		return this.restaurantTable.getId();
	}

	@Override
	public void setRestaurantTableId(Long restaurantTableId) {

		if (restaurantTableId == null) {
			this.restaurantTable = null;
		} else {
			RestaurantTableEntity restaurantTable = new RestaurantTableEntity();
			restaurantTable.setId(restaurantTableId);
			this.restaurantTable = restaurantTable;
		}
	}

	@OneToOne
	@JoinColumn(name = "restaurantTable")
	public RestaurantTableEntity getRestaurantTable() {
		return this.restaurantTable;
	}

	public void setRestaurantTable(RestaurantTableEntity restaurantTable) {
		this.restaurantTable = restaurantTable;
	}

	@OneToMany(mappedBy = "sampleData")
	public List<RestaurantTableEntity> getRestaurantTables() {
		return this.restaurantTables;
	}

	public void setRestaurantTables(List<RestaurantTableEntity> restaurantTables) {
		this.restaurantTables = restaurantTables;
	}

}
