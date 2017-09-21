package com.capgemini.demo.moredatamanagement.logic.api.to;

import com.capgemini.demo.general.common.api.to.AbstractEto;
import com.capgemini.demo.moredatamanagement.common.api.MoreData;

/**
 * Entity transport object of MoreData
 */
public class MoreDataEto extends AbstractEto implements MoreData {

	private static final long serialVersionUID = 1L;
	private String example;

	public String getExample() {
		return this.example;
	}

	public void setExample(String example) {
		this.example = example;
	}

}
