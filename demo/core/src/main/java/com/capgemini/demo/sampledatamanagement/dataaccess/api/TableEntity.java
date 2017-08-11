package com.capgemini.demo.sampledatamanagement.dataaccess.api;

import javax.persistence.Entity;

import com.capgemini.demo.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.demo.sampledatamanagement.common.api.Table;

/**
 * Data access object for Table entities
 */
@Entity
@javax.persistence.Table(name = "Table")
public class TableEntity extends ApplicationPersistenceEntity implements Table {

	private static final long serialVersionUID = 1L;

	private String example;

	public String getExample() {
		return this.example;
	}

	public void setExample(String example) {
		this.example = example;
	}

}
