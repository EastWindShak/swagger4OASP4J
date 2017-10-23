package com.capgemini.demo.sampledatamanagement.service.api.rest;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.http.MediaType;

import com.capgemini.demo.sampledatamanagement.common.api.SampleData;
import com.capgemini.demo.sampledatamanagement.logic.api.Sampledatamanagement;
import com.capgemini.demo.sampledatamanagement.logic.api.to.RestaurantTableEto;
import com.capgemini.demo.sampledatamanagement.logic.api.to.RestaurantTableSearchCriteriaTo;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataEto;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Sampledatamanagement}.
 */
@Path("sampledatamanagement/v1")
public interface SampledatamanagementRestService {

	/**
	 * Delegates to {@link Sampledatamanagement#findRestaurantTable}.
	 *
	 * @param id
	 *            the ID of the {@link RestaurantTableEto}
	 * @return the {@link RestaurantTableEto}
	 */
	@GET
	@Path("/restauranttable/{id}/")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public RestaurantTableEto getRestaurantTable(@PathParam("id") long id);

	/**
	 * Delegates to {@link Sampledatamanagement#saveRestaurantTable}.
	 *
	 * @param restauranttable
	 *            the {@link RestaurantTableEto} to be saved
	 * @return the recently created {@link RestaurantTableEto}
	 */
	@POST
	@Path("/restauranttable/")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public RestaurantTableEto saveRestaurantTable(@Valid RestaurantTableEto restauranttable);

	/**
	 * Delegates to {@link Sampledatamanagement#deleteRestaurantTable}.
	 *
	 * @param id
	 *            ID of the {@link RestaurantTableEto} to be deleted
	 */
	@DELETE
	@Path("/restauranttable/{id}/")
	public void deleteRestaurantTable(@PathParam("id") long id);

	/**
	 * Delegates to {@link Sampledatamanagement#findRestaurantTableEtos}.
	 *
	 * @param searchCriteriaTo
	 *            the pagination and search criteria to be used for finding
	 *            restauranttables.
	 * @return the {@link PaginatedListTo list} of matching
	 *         {@link RestaurantTableEto}s.
	 */
	@Path("/restauranttable/search")
	@POST
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public PaginatedListTo<RestaurantTableEto> findRestaurantTablesByPost(
			@Valid RestaurantTableSearchCriteriaTo searchCriteriaTo);

	/**
	 * Delegates to {@link Sampledatamanagement#findSampleData}.
	 *
	 * @param id
	 *            the ID of the {@link SampleDataEto}
	 * @return the {@link SampleDataEto}
	 */
	@GET
	@Path("/sampledata/{id}/")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public SampleDataEto getSampleData(@PathParam("id") long id);

	/**
	 * Delegates to {@link Sampledatamanagement#saveSampleData}.
	 *
	 * @param sampledata
	 *            the {@link SampleDataEto} to be saved
	 * @return the recently created {@link SampleDataEto}
	 */
	@POST
	@Path("/sampledata/")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public SampleDataEto saveSampleData(@Valid SampleDataEto sampledata);

	/**
	 * Delegates to {@link Sampledatamanagement#deleteSampleData}.
	 *
	 * @param id
	 *            ID of the {@link SampleDataEto} to be deleted
	 */
	@DELETE
	@Path("/sampledata/{id}/")
	public void deleteSampleData(@PathParam("id") long id);

	/**
	 * Delegates to {@link Sampledatamanagement#findSampleDataEtos}.
	 *
	 * @param searchCriteriaTo
	 *            the pagination and search criteria to be used for finding
	 *            sampledatas.
	 * @return the {@link PaginatedListTo list} of matching
	 *         {@link SampleDataEto}s.
	 */
	@Path("/sampledata/search")
	@POST
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public PaginatedListTo<SampleDataEto> findSampleDatasByPost(@Valid SampleDataSearchCriteriaTo searchCriteriaTo);

	@GET
	@Path("/sampledata/custom/{id}/")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public SampleData customMethod(@PathParam("id") @Max(100) @Min(0) long id);

	@DELETE
	@Path("/sampledata/custom/{id}/")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Boolean deleteCustomSampleData(@PathParam("id") @Max(100) @Min(0) long id);

	@POST
	@Path("/sampledata/customSave/")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public PaginatedListTo<SampleDataEto> saveCustomSampleData(SampleDataEto sampleData);

	@POST
	@Path("/sampledata/customSearch/")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.IMAGE_PNG_VALUE)
	public PaginatedListTo<SampleDataEto> findCustomSampleDataEtos(SampleDataSearchCriteriaTo criteria);

}
