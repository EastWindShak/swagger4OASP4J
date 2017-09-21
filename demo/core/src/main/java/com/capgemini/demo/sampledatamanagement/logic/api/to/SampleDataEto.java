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

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
