package com.capgemini.demo.sampledatamanagement.logic.api;

import com.capgemini.demo.sampledatamanagement.logic.api.to.RestaurantTableEto;
import com.capgemini.demo.sampledatamanagement.logic.api.to.RestaurantTableSearchCriteriaTo;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataEto;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Sampledatamanagement component.
 */
public interface Sampledatamanagement {

	/**
	 * Returns a RestaurantTable by its id 'id'.
	 *
	 * @param id
	 *            The id 'id' of the RestaurantTable.
	 * @return The {@link RestaurantTableEto} with id 'id'
	 */
	RestaurantTableEto findRestaurantTable(Long id);

	/**
	 * Returns a paginated list of RestaurantTables matching the search
	 * criteria.
	 *
	 * @param criteria
	 *            the {@link RestaurantTableSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link RestaurantTableEto}s.
	 */
	PaginatedListTo<RestaurantTableEto> findRestaurantTableEtos(RestaurantTableSearchCriteriaTo criteria);

	/**
	 * Deletes a restaurantTable from the database by its id
	 * 'restaurantTableId'.
	 *
	 * @param restaurantTableId
	 *            Id of the restaurantTable to delete
	 * @return boolean <code>true</code> if the restaurantTable can be deleted,
	 *         <code>false</code> otherwise
	 */
	boolean deleteRestaurantTable(Long restaurantTableId);

	/**
	 * Saves a restaurantTable and store it in the database.
	 *
	 * @param restaurantTable
	 *            the {@link RestaurantTableEto} to create.
	 * @return the new {@link RestaurantTableEto} that has been saved with ID
	 *         and version.
	 */
	RestaurantTableEto saveRestaurantTable(RestaurantTableEto restaurantTable);

	/**
	 * Returns a SampleData by its id 'id'.
	 *
	 * @param id
	 *            The id 'id' of the SampleData.
	 * @return The {@link SampleDataEto} with id 'id'
	 */
	SampleDataEto findSampleData(Long id);

	/**
	 * Returns a paginated list of SampleDatas matching the search criteria.
	 *
	 * @param criteria
	 *            the {@link SampleDataSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link SampleDataEto}s.
	 */
	PaginatedListTo<SampleDataEto> findSampleDataEtos(SampleDataSearchCriteriaTo criteria);

	/**
	 * Deletes a sampleData from the database by its id 'sampleDataId'.
	 *
	 * @param sampleDataId
	 *            Id of the sampleData to delete
	 * @return boolean <code>true</code> if the sampleData can be deleted,
	 *         <code>false</code> otherwise
	 */
	boolean deleteSampleData(Long sampleDataId);

	/**
	 * Saves a sampleData and store it in the database.
	 *
	 * @param sampleData
	 *            the {@link SampleDataEto} to create.
	 * @return the new {@link SampleDataEto} that has been saved with ID and
	 *         version.
	 */
	SampleDataEto saveSampleData(SampleDataEto sampleData);

	SampleDataEto customMethod(long id);

	boolean deleteCustomSampleData(long id);

	PaginatedListTo<SampleDataEto> saveCustomSampleData(SampleDataEto sampleData);

	PaginatedListTo<SampleDataEto> findCustomSampleDataEtos(SampleDataSearchCriteriaTo criteria);

}
