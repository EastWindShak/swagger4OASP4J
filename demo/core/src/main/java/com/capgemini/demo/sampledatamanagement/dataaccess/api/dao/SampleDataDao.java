package com.capgemini.demo.sampledatamanagement.dataaccess.api.dao;

import com.capgemini.demo.general.dataaccess.api.dao.ApplicationDao;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.SampleDataEntity;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for SampleData entities
 */
public interface SampleDataDao extends ApplicationDao<SampleDataEntity> {

	/**
	 * Finds the {@link SampleDataEntity sampledatas} matching the given
	 * {@link SampleDataSearchCriteriaTo}.
	 *
	 * @param criteria
	 *            is the {@link SampleDataSearchCriteriaTo}.
	 * @return the {@link PaginatedListTo} with the matching
	 *         {@link SampleDataEntity} objects.
	 */
	PaginatedListTo<SampleDataEntity> findSampleDatas(SampleDataSearchCriteriaTo criteria);
}
