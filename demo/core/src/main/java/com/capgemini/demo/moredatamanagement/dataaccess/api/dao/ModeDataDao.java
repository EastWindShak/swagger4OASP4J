package com.capgemini.demo.moredatamanagement.dataaccess.api.dao;

import com.capgemini.demo.general.dataaccess.api.dao.ApplicationDao;
import com.capgemini.demo.moredatamanagement.dataaccess.api.ModeDataEntity;
import com.capgemini.demo.moredatamanagement.logic.api.to.ModeDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for ModeData entities
 */
public interface ModeDataDao extends ApplicationDao<ModeDataEntity> {

	/**
	 * Finds the {@link ModeDataEntity modedatas} matching the given
	 * {@link ModeDataSearchCriteriaTo}.
	 *
	 * @param criteria
	 *            is the {@link ModeDataSearchCriteriaTo}.
	 * @return the {@link PaginatedListTo} with the matching
	 *         {@link ModeDataEntity} objects.
	 */
	PaginatedListTo<ModeDataEntity> findModeDatas(ModeDataSearchCriteriaTo criteria);
}
