package com.capgemini.demo.sampledatamanagement.dataaccess.api;

import java.util.List;

import javax.persistence.Entity;

import com.capgemini.demo.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.demo.sampledatamanagement.common.api.RestaurantTable;

/**
 * Data access object for RestaurantTable entities
 */
@Entity
@javax.persistence.Table(name = "RestaurantTable")
public class RestaurantTableEntity extends ApplicationPersistenceEntity implements RestaurantTable {

	private static final long serialVersionUID = 1L;

	private Integer seats;

	private List<Long> moreDataIds;

	@Override
	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	@Override
	public Integer getSeats() {
		return this.seats;
	}

	public List<Long> getMoreDataIds() {
		return this.moreDataIds;
	}

	public void setMoreDataIds(List<Long> moreDataIds) {
		this.moreDataIds = moreDataIds;
	}
}
