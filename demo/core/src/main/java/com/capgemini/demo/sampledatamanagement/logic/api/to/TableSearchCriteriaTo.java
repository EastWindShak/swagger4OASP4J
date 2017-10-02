package com.capgemini.demo.sampledatamanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria}
 * {@link net.sf.mmm.util.transferobject.api.TransferObject TO} used to find
 * {@link com.capgemini.demo.sampledatamanagement.common.api.Table}s.
 *
 */
public class TableSearchCriteriaTo extends SearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private Integer seats;

	/**
	 * The constructor.
	 */
	public TableSearchCriteriaTo() {

		super();
	}

	public Integer getSeats() {
		return this.seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

}