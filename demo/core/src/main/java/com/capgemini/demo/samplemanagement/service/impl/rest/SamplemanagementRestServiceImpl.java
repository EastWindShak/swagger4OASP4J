package com.capgemini.demo.samplemanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.capgemini.demo.samplemanagement.logic.api.Samplemanagement;
import com.capgemini.demo.samplemanagement.logic.api.to.SampleEto;
import com.capgemini.demo.samplemanagement.logic.api.to.SampleSearchCriteriaTo;
import com.capgemini.demo.samplemanagement.service.api.rest.SamplemanagementRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Samplemanagement}.
 */
@Named("SamplemanagementRestService")
public class SamplemanagementRestServiceImpl implements SamplemanagementRestService {

  @Inject
  private Samplemanagement samplemanagement;

  @Override
  public SampleEto getSample(long id) {

    return this.samplemanagement.findSample(id);
  }

  @Override
  public SampleEto saveSample(SampleEto sample) {

    return this.samplemanagement.saveSample(sample);
  }

  @Override
  public void deleteSample(long id) {

    this.samplemanagement.deleteSample(id);
  }

  @Override
  public PaginatedListTo<SampleEto> findSamplesByPost(SampleSearchCriteriaTo searchCriteriaTo) {

    return this.samplemanagement.findSampleEtos(searchCriteriaTo);
  }

}
