package com.capgemini.demo.sampledatamanagement.dataaccess.api.dao;

import com.capgemini.demo.general.dataaccess.api.dao.ApplicationDao;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.TableEntity;
import com.capgemini.demo.sampledatamanagement.logic.api.to.TableSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Table entities
 */
public interface TableDao extends ApplicationDao<TableEntity> {

	/**
	 * Finds the {@link TableEntity tables} matching the given
	 * {@link TableSearchCriteriaTo}.
	 *
	 * @param criteria
	 *            is the {@link TableSearchCriteriaTo}.
	 * @return the {@link PaginatedListTo} with the matching {@link TableEntity}
	 *         objects.
	 */
	PaginatedListTo<TableEntity> findTables(TableSearchCriteriaTo criteria);
}
