package com.capgemini.demo.sampledatamanagement.logic.api;

import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataEto;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;
import com.capgemini.demo.sampledatamanagement.logic.api.to.TableEto;
import com.capgemini.demo.sampledatamanagement.logic.api.to.TableSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Sampledatamanagement component.
 */
public interface Sampledatamanagement {

	/**
	 * Returns a Table by its id 'id'.
	 *
	 * @param id
	 *            The id 'id' of the Table.
	 * @return The {@link TableEto} with id 'id'
	 */
	TableEto findTable(Long id);

	/**
	 * Returns a paginated list of Tables matching the search criteria.
	 *
	 * @param criteria
	 *            the {@link TableSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link TableEto}s.
	 */
	PaginatedListTo<TableEto> findTableEtos(TableSearchCriteriaTo criteria);

	/**
	 * Deletes a table from the database by its id 'tableId'.
	 *
	 * @param tableId
	 *            Id of the table to delete
	 * @return boolean <code>true</code> if the table can be deleted,
	 *         <code>false</code> otherwise
	 */
	boolean deleteTable(Long tableId);

	/**
	 * Saves a table and store it in the database.
	 *
	 * @param table
	 *            the {@link TableEto} to create.
	 * @return the new {@link TableEto} that has been saved with ID and version.
	 */
	TableEto saveTable(TableEto table);

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
