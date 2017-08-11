package com.capgemini.demo.samplemanagement.service.api.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.capgemini.demo.samplemanagement.logic.api.Samplemanagement;
import com.capgemini.demo.samplemanagement.logic.api.to.SampleEto;
import com.capgemini.demo.samplemanagement.logic.api.to.SampleSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Samplemanagement}.
 */
@Path("/samplemanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface SamplemanagementRestService {

  /**
   * Delegates to {@link Samplemanagement#findSample}.
   *
   * @param id the ID of the {@link SampleEto}
   * @return the {@link SampleEto}
   */
  @GET
  @Path("/sample/{id}/")
  public SampleEto getSample(@PathParam("id") @Min(0) @Max(100) long id);

  /**
   * Delegates to {@link Samplemanagement#saveSample}.
   *
   * @param sample the {@link SampleEto} to be saved
   * @return the recently created {@link SampleEto}
   */
  @POST
  @Path("/sample/")
  public SampleEto saveSample(SampleEto sample);

  /**
   * Delegates to {@link Samplemanagement#deleteSample}.
   *
   * @param id ID of the {@link SampleEto} to be deleted
   */
  @DELETE
  @Path("/sample/{id}/")
  public void deleteSample(@PathParam("id") long id);

  /**
   * Delegates to {@link Samplemanagement#findSampleEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding samples.
   * @return the {@link PaginatedListTo list} of matching {@link SampleEto}s.
   */
  @Path("/sample/search")
  @POST
  public PaginatedListTo<SampleEto> findSamplesByPost(SampleSearchCriteriaTo searchCriteriaTo);

}
