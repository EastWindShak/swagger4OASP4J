package com.capgemini.devonfw.sampledatamanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.capgemini.devonfw.sampledatamanagement.logic.api.Sampledatamanagement;
import com.capgemini.devonfw.sampledatamanagement.logic.api.to.SampleDataEto;
import com.capgemini.devonfw.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;
import com.capgemini.devonfw.sampledatamanagement.service.api.rest.SampledatamanagementRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Sampledatamanagement}.
 */
@Named("SampledatamanagementRestService")
public class SampledatamanagementRestServiceImpl implements SampledatamanagementRestService {

  @Inject
  private Sampledatamanagement sampledatamanagement;

  @Override
  public SampleDataEto getSampleData(long id) {

    return this.sampledatamanagement.findSampleData(id);
  }

  @Override
  public SampleDataEto saveSampleData(SampleDataEto sampledata) {

    return this.sampledatamanagement.saveSampleData(sampledata);
  }

  @Override
  public void deleteSampleData(long id) {

    this.sampledatamanagement.deleteSampleData(id);
  }

  @Override
  public PaginatedListTo<SampleDataEto> findSampleDatasByPost(SampleDataSearchCriteriaTo searchCriteriaTo) {

    return this.sampledatamanagement.findSampleDataEtos(searchCriteriaTo);
  }

}