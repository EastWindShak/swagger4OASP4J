package com.capgemini.demo.moredatamanagement.service.api.rest;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.capgemini.demo.moredatamanagement.logic.api.Moredatamanagement;
import com.capgemini.demo.moredatamanagement.logic.api.to.MoreDataEto;
import com.capgemini.demo.moredatamanagement.logic.api.to.MoreDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Moredatamanagement}.
 */
@Path("moredatamanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface MoredatamanagementRestService {

	/**
	 * Delegates to {@link Moredatamanagement#findMoreData}.
	 *
	 * @param id
	 *            the ID of the {@link MoreDataEto}
	 * @return the {@link MoreDataEto}
	 */
	@GET
	@Path("/moredata/{id}/")
	public MoreDataEto getMoreData(@PathParam("id") long id);

	/**
	 * Delegates to {@link Moredatamanagement#saveMoreData}.
	 *
	 * @param moredata
	 *            the {@link MoreDataEto} to be saved
	 * @return the recently created {@link MoreDataEto}
	 */
	@POST
	@Path("/moredata/")
	public MoreDataEto saveMoreData(@Valid MoreDataEto moredata);

	/**
	 * Delegates to {@link Moredatamanagement#deleteMoreData}.
	 *
	 * @param id
	 *            ID of the {@link MoreDataEto} to be deleted
	 */
	@DELETE
	@Path("/moredata/{id}/")
	public void deleteMoreData(@PathParam("id") long id);

	/**
	 * Delegates to {@link Moredatamanagement#findMoreDataEtos}.
	 *
	 * @param searchCriteriaTo
	 *            the pagination and search criteria to be used for finding
	 *            moredatas.
	 * @return the {@link PaginatedListTo list} of matching {@link MoreDataEto}
	 *         s.
	 */
	@Path("/moredata/search")
	@POST
	public PaginatedListTo<MoreDataEto> findMoreDatasByPost(@Valid MoreDataSearchCriteriaTo searchCriteriaTo);

}
