package com.capgemini.demo.moredatamanagement.dataaccess.api.dao;

import com.capgemini.demo.general.dataaccess.api.dao.ApplicationDao;
import com.capgemini.demo.moredatamanagement.dataaccess.api.MoreDataEntity;
import com.capgemini.demo.moredatamanagement.logic.api.to.MoreDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for MoreData entities
 */
public interface MoreDataDao extends ApplicationDao<MoreDataEntity> {

	/**
	 * Finds the {@link MoreDataEntity moredatas} matching the given
	 * {@link MoreDataSearchCriteriaTo}.
	 *
	 * @param criteria
	 *            is the {@link MoreDataSearchCriteriaTo}.
	 * @return the {@link PaginatedListTo} with the matching
	 *         {@link MoreDataEntity} objects.
	 */
	PaginatedListTo<MoreDataEntity> findMoreDatas(MoreDataSearchCriteriaTo criteria);
}
