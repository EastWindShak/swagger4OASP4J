package com.capgemini.demo.moredatamanagement.logic.api;

import com.capgemini.demo.moredatamanagement.logic.api.to.MoreDataEto;
import com.capgemini.demo.moredatamanagement.logic.api.to.MoreDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Moredatamanagement component.
 */
public interface Moredatamanagement {
	/**
	 * Returns a MoreData by its id 'id'.
	 *
	 * @param id
	 *            The id 'id' of the MoreData.
	 * @return The {@link MoreDataEto} with id 'id'
	 */
	MoreDataEto findMoreData(Long id);

	/**
	 * Returns a paginated list of MoreDatas matching the search criteria.
	 *
	 * @param criteria
	 *            the {@link MoreDataSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link MoreDataEto}s.
	 */
	PaginatedListTo<MoreDataEto> findMoreDataEtos(MoreDataSearchCriteriaTo criteria);

	/**
	 * Deletes a moreData from the database by its id 'moreDataId'.
	 *
	 * @param moreDataId
	 *            Id of the moreData to delete
	 * @return boolean <code>true</code> if the moreData can be deleted,
	 *         <code>false</code> otherwise
	 */
	boolean deleteMoreData(Long moreDataId);

	/**
	 * Saves a moreData and store it in the database.
	 *
	 * @param moreData
	 *            the {@link MoreDataEto} to create.
	 * @return the new {@link MoreDataEto} that has been saved with ID and
	 *         version.
	 */
	MoreDataEto saveMoreData(MoreDataEto moreData);

}
