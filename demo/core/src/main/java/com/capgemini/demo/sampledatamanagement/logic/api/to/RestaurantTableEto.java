package com.capgemini.demo.sampledatamanagement.logic.api.to;

import com.capgemini.demo.general.common.api.to.AbstractEto;
import com.capgemini.demo.sampledatamanagement.common.api.RestaurantTable;

/**
 * Entity transport object of RestaurantTable
 */
public class RestaurantTableEto extends AbstractEto implements RestaurantTable {

	private static final long serialVersionUID = 1L;
	private Integer seats;

	public Integer getSeats() {
		return this.seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

}
