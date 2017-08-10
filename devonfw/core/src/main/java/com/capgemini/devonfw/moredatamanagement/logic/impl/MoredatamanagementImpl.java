package com.capgemini.devonfw.moredatamanagement.logic.impl;

import java.util.Objects;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capgemini.devonfw.general.common.api.constants.PermissionConstants;
import com.capgemini.devonfw.general.logic.base.AbstractComponentFacade;
import com.capgemini.devonfw.moredatamanagement.dataaccess.api.MoreDataEntity;
import com.capgemini.devonfw.moredatamanagement.dataaccess.api.dao.MoreDataDao;
import com.capgemini.devonfw.moredatamanagement.logic.api.Moredatamanagement;
import com.capgemini.devonfw.moredatamanagement.logic.api.to.MoreDataEto;
import com.capgemini.devonfw.moredatamanagement.logic.api.to.MoreDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of moredatamanagement
 */
@Named
@Transactional
public class MoredatamanagementImpl extends AbstractComponentFacade implements Moredatamanagement {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(MoredatamanagementImpl.class);

  /**
   * @see #getMoreDataDao()
   */
  @Inject
  private MoreDataDao moreDataDao;

  /**
   * The constructor.
   */
  public MoredatamanagementImpl() {

    super();
  }

  @Override
  public MoreDataEto findMoreData(Long id) {

    LOG.debug("Get MoreData with id {} from database.", id);
    return getBeanMapper().map(getMoreDataDao().findOne(id), MoreDataEto.class);
  }

  @Override
  @RolesAllowed(PermissionConstants.FIND_MORE_DATA)
  public PaginatedListTo<MoreDataEto> findMoreDataEtos(MoreDataSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<MoreDataEntity> moredatas = getMoreDataDao().findMoreDatas(criteria);
    return mapPaginatedEntityList(moredatas, MoreDataEto.class);
  }

  @Override
  @RolesAllowed(PermissionConstants.DELETE_MORE_DATA)
  public boolean deleteMoreData(Long moreDataId) {

    MoreDataEntity moreData = getMoreDataDao().find(moreDataId);
    getMoreDataDao().delete(moreData);
    LOG.debug("The moreData with id '{}' has been deleted.", moreDataId);
    return true;
  }

  @Override
  @RolesAllowed(PermissionConstants.SAVE_MORE_DATA)
  public MoreDataEto saveMoreData(MoreDataEto moreData) {

    Objects.requireNonNull(moreData, "moreData");
    MoreDataEntity moreDataEntity = getBeanMapper().map(moreData, MoreDataEntity.class);

    // initialize, validate moreDataEntity here if necessary
    getMoreDataDao().save(moreDataEntity);
    LOG.debug("MoreData with id '{}' has been created.", moreDataEntity.getId());

    return getBeanMapper().map(moreDataEntity, MoreDataEto.class);
  }

  /**
   * Returns the field 'moreDataDao'.
   *
   * @return the {@link MoreDataDao} instance.
   */
  public MoreDataDao getMoreDataDao() {

    return this.moreDataDao;
  }

}
