package com.capgemini.demo.sampledatamanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria}
 * {@link net.sf.mmm.util.transferobject.api.TransferObject TO} used to find
 * {@link com.capgemini.demo.sampledatamanagement.common.api.SampleData}s.
 *
 */
public class SampleDataSearchCriteriaTo extends SearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String name;
	private String surname;
	private Integer age;
	private String mail;
	private Long restaurantTableId;

	/**
	 * The constructor.
	 */
	public SampleDataSearchCriteriaTo() {

		super();
	}

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

	public void setRestaurantTableId(Long restaurantTableId) {
		this.restaurantTableId = restaurantTableId;
	}

	public Long getRestaurantTableId() {
		return this.restaurantTableId;
	}

}
