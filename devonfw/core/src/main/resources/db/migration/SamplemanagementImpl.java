package com.capgemini.demo.samplemanagement.logic.impl;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.demo.general.common.api.constants.PermissionConstants;
import com.capgemini.demo.general.logic.base.AbstractComponentFacade;
import com.capgemini.demo.samplemanagement.dataaccess.api.SampleEntity;
import com.capgemini.demo.samplemanagement.dataaccess.api.dao.SampleDao;
import com.capgemini.demo.samplemanagement.logic.api.Samplemanagement;
import com.capgemini.demo.samplemanagement.logic.api.to.SampleEto;
import com.capgemini.demo.samplemanagement.logic.api.to.SampleSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of samplemanagement
 */
@Named
@Transactional
public class SamplemanagementImpl extends AbstractComponentFacade implements Samplemanagement {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(SamplemanagementImpl.class);

  /**
   * @see #getSampleDao()
   */
  @Inject
  private SampleDao sampleDao;

  /**
   * The constructor.
   */
  public SamplemanagementImpl() {

    super();
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_SAMPLE)
  public SampleEto findSample(Long id) {

    LOG.debug("Get Sample with id {} from database.", id);
    return getBeanMapper().map(getSampleDao().findOne(id), SampleEto.class);
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_SAMPLE)
  public PaginatedListTo<SampleEto> findSampleEtos(SampleSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<SampleEntity> samples = getSampleDao().findSamples(criteria);
    return mapPaginatedEntityList(samples, SampleEto.class);
  }

  @Override
  @RolesAllowed(PermissionConstants.DELETE_SAMPLE)
  public boolean deleteSample(Long sampleId) {

    SampleEntity sample = getSampleDao().find(sampleId);
    getSampleDao().delete(sample);
    LOG.debug("The sample with id '{}' has been deleted.", sampleId);
    return true;
  }

  @Override
  @RolesAllowed(PermissionConstants.SAVE_SAMPLE)
  public SampleEto saveSample(SampleEto sample) {

    Objects.requireNonNull(sample, "sample");
    SampleEntity sampleEntity = getBeanMapper().map(sample, SampleEntity.class);

    // initialize, validate sampleEntity here if necessary
    SampleEntity resultEntity = getSampleDao().save(sampleEntity);
    LOG.debug("Sample with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, SampleEto.class);
  }

  /**
   * Returns the field 'sampleDao'.
   *
   * @return the {@link SampleDao} instance.
   */
  public SampleDao getSampleDao() {

    return this.sampleDao;
  }

}
