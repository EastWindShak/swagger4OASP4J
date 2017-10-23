package com.capgemini.demo.sampledatamanagement.logic.api.to;

import com.capgemini.demo.general.common.api.to.AbstractCto;
import com.capgemini.demo.sampledatamanagement.common.api.RestaurantTable;

/**
 * Composite transport object of RestaurantTable
 */
public class RestaurantTableCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private RestaurantTableEto restaurantTable;

	public RestaurantTable getRestaurantTable() {
		return restaurantTable;
	}

	public void setRestaurantTable(RestaurantTableEto restaurantTable) {
		this.restaurantTable = restaurantTable;
	}

}
