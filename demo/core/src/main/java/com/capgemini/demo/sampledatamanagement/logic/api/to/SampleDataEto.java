package com.capgemini.demo.sampledatamanagement.logic.api.to;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.capgemini.demo.general.common.api.to.AbstractEto;
import com.capgemini.demo.sampledatamanagement.common.api.SampleData;

/**
 * Entity transport object of SampleData
 */
public class SampleDataEto extends AbstractEto implements SampleData {

	private static final long serialVersionUID = 1L;
	/**
	 * Unique identifier representing a specific SampleData
	 */
	@Max(100)
	@Min(4)
	private Long id;

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

	private Long dataId;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	@Override
	public Long getDataId() {
		return this.dataId;
	}

}
