package com.capgemini.demo.moredatamanagement.dataaccess.api;

import javax.persistence.Entity;

import com.capgemini.demo.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.demo.moredatamanagement.common.api.MoreData;

/**
 * Data access object for MoreData entities
 */
@Entity
@javax.persistence.Table(name = "MoreData")
public class MoreDataEntity extends ApplicationPersistenceEntity implements MoreData {

	private static final long serialVersionUID = 1L;

	private String example;

	public String getExample() {
		return this.example;
	}

	public void setExample(String example) {
		this.example = example;
	}

}
