package com.capgemini.demo.sampledatamanagement.logic.api.to;

import java.util.List;

import com.capgemini.demo.general.common.api.to.AbstractCto;
import com.capgemini.demo.sampledatamanagement.common.api.SampleData;

/**
 * Composite transport object of SampleData
 */
public class SampleDataCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private SampleDataEto sampleData;

	private RestaurantTableEto restaurantTable;

	private List<RestaurantTableEto> restaurantTables;

	public SampleData getSampleData() {
		return sampleData;
	}

	public void setSampleData(SampleDataEto sampleData) {
		this.sampleData = sampleData;
	}

	public RestaurantTableEto getRestaurantTable() {
		return this.restaurantTable;
	}

	public void setRestaurantTable(RestaurantTableEto restaurantTable) {
		this.restaurantTable = restaurantTable;
	}

	public List<RestaurantTableEto> getRestaurantTables() {
		return this.restaurantTables;
	}

	public void setRestaurantTables(List<RestaurantTableEto> restaurantTables) {
		this.restaurantTables = restaurantTables;
	}

}
