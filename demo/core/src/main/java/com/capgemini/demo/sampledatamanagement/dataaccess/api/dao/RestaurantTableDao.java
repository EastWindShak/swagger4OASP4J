package com.capgemini.demo.sampledatamanagement.dataaccess.api.dao;

import com.capgemini.demo.general.dataaccess.api.dao.ApplicationDao;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.RestaurantTableEntity;
import com.capgemini.demo.sampledatamanagement.logic.api.to.RestaurantTableSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for RestaurantTable entities
 */
public interface RestaurantTableDao extends ApplicationDao<RestaurantTableEntity> {

	/**
	 * Finds the {@link RestaurantTableEntity restauranttables} matching the
	 * given {@link RestaurantTableSearchCriteriaTo}.
	 *
	 * @param criteria
	 *            is the {@link RestaurantTableSearchCriteriaTo}.
	 * @return the {@link PaginatedListTo} with the matching
	 *         {@link RestaurantTableEntity} objects.
	 */
	PaginatedListTo<RestaurantTableEntity> findRestaurantTables(RestaurantTableSearchCriteriaTo criteria);
}
