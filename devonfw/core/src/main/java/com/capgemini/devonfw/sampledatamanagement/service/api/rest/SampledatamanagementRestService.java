package com.capgemini.devonfw.sampledatamanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.capgemini.devonfw.sampledatamanagement.logic.api.Sampledatamanagement;
import com.capgemini.devonfw.sampledatamanagement.logic.api.to.SampleDataEto;
import com.capgemini.devonfw.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Sampledatamanagement}.
 */
@Path("/sampledatamanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface SampledatamanagementRestService {

  /**
   * Delegates to {@link Sampledatamanagement#findSampleData}.
   *
   * @param id the ID of the {@link SampleDataEto}
   * @return the {@link SampleDataEto}
   */
  @GET
  @Path("/sampledata/{id}/")
  public SampleDataEto getSampleData(@PathParam("id") long id);

  /**
   * Delegates to {@link Sampledatamanagement#saveSampleData}.
   *
   * @param sampledata the {@link SampleDataEto} to be saved
   * @return the recently created {@link SampleDataEto}
   */
  @POST
  @Path("/sampledata/")
  public SampleDataEto saveSampleData(SampleDataEto sampledata);

  /**
   * Delegates to {@link Sampledatamanagement#deleteSampleData}.
   *
   * @param id ID of the {@link SampleDataEto} to be deleted
   */
  @DELETE
  @Path("/sampledata/{id}/")
  public void deleteSampleData(@PathParam("id") long id);

  /**
   * Delegates to {@link Sampledatamanagement#findSampleDataEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding sampledatas.
   * @return the {@link PaginatedListTo list} of matching {@link SampleDataEto}s.
   */
  @Path("/sampledata/search")
  @POST
  public PaginatedListTo<SampleDataEto> findSampleDatasByPost(SampleDataSearchCriteriaTo searchCriteriaTo);

}