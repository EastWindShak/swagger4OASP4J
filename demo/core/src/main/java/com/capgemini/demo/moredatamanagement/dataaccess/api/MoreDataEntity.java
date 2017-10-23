package com.capgemini.demo.moredatamanagement.dataaccess.api;

import java.util.List;

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

	private Long sampleDataId;

	private List<Long> restaurantTableIds;

	@Override
	public void setExample(String example) {
		this.example = example;
	}

	@Override
	public String getExample() {
		return this.example;
	}

	@Override
	public Long getSampleDataId() {
		return this.sampleDataId;
	}

	@Override
	public void setSampleDataId(Long sampleDataId) {
		this.sampleDataId = sampleDataId;
	}

	public List<Long> getRestaurantTableIds() {
		return this.restaurantTableIds;
	}

	public void setRestaurantTableIds(List<Long> restaurantTableIds) {
		this.restaurantTableIds = restaurantTableIds;
	}
}
