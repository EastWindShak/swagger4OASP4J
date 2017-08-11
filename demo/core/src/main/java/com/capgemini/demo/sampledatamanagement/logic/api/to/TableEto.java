package com.capgemini.demo.sampledatamanagement.logic.api.to;

import com.capgemini.demo.general.common.api.to.AbstractEto;
import com.capgemini.demo.sampledatamanagement.common.api.Table;

/**
 * Entity transport object of Table
 */
public class TableEto extends AbstractEto implements Table {

	private static final long serialVersionUID = 1L;
	private String example;

	public String getExample() {
		return this.example;
	}

	public void setExample(String example) {
		this.example = example;
	}

}
