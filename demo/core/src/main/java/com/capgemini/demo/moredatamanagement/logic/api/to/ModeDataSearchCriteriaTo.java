package com.capgemini.demo.moredatamanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria}
 * {@link net.sf.mmm.util.transferobject.api.TransferObject TO} used to find
 * {@link com.capgemini.demo.moredatamanagement.common.api.ModeData}s.
 *
 */
public class ModeDataSearchCriteriaTo extends SearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String example;

	/**
	 * The constructor.
	 */
	public ModeDataSearchCriteriaTo() {

		super();
	}

	public String getExample() {
		return this.example;
	}

	public void setExample(String example) {
		this.example = example;
	}

}
