package com.capgemini.devonfw.moredatamanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.capgemini.devonfw.moredatamanagement.logic.api.Moredatamanagement;
import com.capgemini.devonfw.moredatamanagement.logic.api.to.MoreDataEto;
import com.capgemini.devonfw.moredatamanagement.logic.api.to.MoreDataSearchCriteriaTo;
import com.capgemini.devonfw.moredatamanagement.service.api.rest.MoredatamanagementRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Moredatamanagement}.
 */
@Named("MoredatamanagementRestService")
public class MoredatamanagementRestServiceImpl implements MoredatamanagementRestService {

  @Inject
  private Moredatamanagement moredatamanagement;

  @Override
  public MoreDataEto getMoreData(long id) {

    return this.moredatamanagement.findMoreData(id);
  }

  @Override
  public MoreDataEto saveMoreData(MoreDataEto moredata) {

    return this.moredatamanagement.saveMoreData(moredata);
  }

  @Override
  public void deleteMoreData(long id) {

    this.moredatamanagement.deleteMoreData(id);
  }

  @Override
  public PaginatedListTo<MoreDataEto> findMoreDatasByPost(MoreDataSearchCriteriaTo searchCriteriaTo) {

    return this.moredatamanagement.findMoreDataEtos(searchCriteriaTo);
  }

}