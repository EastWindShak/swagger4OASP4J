package com.capgemini.devonfw.sampledatamanagement.logic.impl;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capgemini.devonfw.general.common.api.constants.PermissionConstants;
import com.capgemini.devonfw.general.logic.base.AbstractComponentFacade;
import com.capgemini.devonfw.sampledatamanagement.dataaccess.api.SampleDataEntity;
import com.capgemini.devonfw.sampledatamanagement.dataaccess.api.dao.SampleDataDao;
import com.capgemini.devonfw.sampledatamanagement.logic.api.Sampledatamanagement;
import com.capgemini.devonfw.sampledatamanagement.logic.api.to.SampleDataEto;
import com.capgemini.devonfw.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of sampledatamanagement
 */
@Named
@Transactional
public class SampledatamanagementImpl extends AbstractComponentFacade implements Sampledatamanagement {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(SampledatamanagementImpl.class);

  /**
   * @see #getSampleDataDao()
   */
  @Inject
  private SampleDataDao sampleDataDao;

  /**
   * The constructor.
   */
  public SampledatamanagementImpl() {

    super();
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_SAMPLE_DATA)
  public SampleDataEto findSampleData(Long id) {

    LOG.debug("Get SampleData with id {} from database.", id);
    return getBeanMapper().map(getSampleDataDao().findOne(id), SampleDataEto.class);
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_SAMPLE_DATA)
  public PaginatedListTo<SampleDataEto> findSampleDataEtos(SampleDataSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<SampleDataEntity> sampledatas = getSampleDataDao().findSampleDatas(criteria);
    return mapPaginatedEntityList(sampledatas, SampleDataEto.class);
  }

  @Override
  @RolesAllowed(PermissionConstants.DELETE_SAMPLE_DATA)
  public boolean deleteSampleData(Long sampleDataId) {

    SampleDataEntity sampleData = getSampleDataDao().find(sampleDataId);
    getSampleDataDao().delete(sampleData);
    LOG.debug("The sampleData with id '{}' has been deleted.", sampleDataId);
    return true;
  }

  @Override
  @RolesAllowed(PermissionConstants.SAVE_SAMPLE_DATA)
  public SampleDataEto saveSampleData(SampleDataEto sampleData) {

    Objects.requireNonNull(sampleData, "sampleData");
    SampleDataEntity sampleDataEntity = getBeanMapper().map(sampleData, SampleDataEntity.class);

    // initialize, validate sampleDataEntity here if necessary
    getSampleDataDao().save(sampleDataEntity);
    LOG.debug("SampleData with id '{}' has been created.", sampleDataEntity.getId());

    return getBeanMapper().map(sampleDataEntity, SampleDataEto.class);
  }

  /**
   * Returns the field 'sampleDataDao'.
   *
   * @return the {@link SampleDataDao} instance.
   */
  public SampleDataDao getSampleDataDao() {

    return this.sampleDataDao;
  }

}
