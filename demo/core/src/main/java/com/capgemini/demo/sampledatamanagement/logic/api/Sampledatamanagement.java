package com.capgemini.demo.sampledatamanagement.logic.api;

import com.capgemini.demo.sampledatamanagement.common.api.SampleData;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataEto;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Sampledatamanagement component.
 */
public interface Sampledatamanagement {
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

	PaginatedListTo<SampleDataEto> saveCustomSampleData(SampleData sampleData);

	PaginatedListTo<SampleDataEto> findCustomSampleDataEtos(SampleDataSearchCriteriaTo criteria);
}
