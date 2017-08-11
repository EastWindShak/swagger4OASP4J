package com.capgemini.demo.samplemanagement.dataaccess.api.dao;

import com.capgemini.demo.general.dataaccess.api.dao.ApplicationDao;
import com.capgemini.demo.samplemanagement.dataaccess.api.SampleEntity;
import com.capgemini.demo.samplemanagement.logic.api.to.SampleSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Sample entities
 */
public interface SampleDao extends ApplicationDao<SampleEntity> {

  /**
   * Finds the {@link SampleEntity samples} matching the given {@link SampleSearchCriteriaTo}.
   *
   * @param criteria is the {@link SampleSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link SampleEntity} objects.
   */
  PaginatedListTo<SampleEntity> findSamples(SampleSearchCriteriaTo criteria);

}
