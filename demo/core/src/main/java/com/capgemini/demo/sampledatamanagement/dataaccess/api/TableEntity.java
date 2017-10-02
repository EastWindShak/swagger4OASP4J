package com.capgemini.demo.sampledatamanagement.dataaccess.api;

import javax.persistence.Entity;

import com.capgemini.demo.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.demo.sampledatamanagement.common.api.Table;

/**
 * sampledatamanagement
 */
@Entity
@javax.persistence.Table(name = "RestaurantTable")
public class TableEntity extends ApplicationPersistenceEntity implements Table {

	private static final long serialVersionUID = 1L;

	private Integer seats;

	public Integer getSeats() {
		return this.seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

}
