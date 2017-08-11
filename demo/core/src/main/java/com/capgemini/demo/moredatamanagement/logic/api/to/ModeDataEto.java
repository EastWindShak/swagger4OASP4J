package com.capgemini.demo.moredatamanagement.logic.api.to;

import com.capgemini.demo.general.common.api.to.AbstractEto;
import com.capgemini.demo.moredatamanagement.common.api.ModeData;

/**
 * Entity transport object of ModeData
 */
public class ModeDataEto extends AbstractEto implements ModeData {

	private static final long serialVersionUID = 1L;
	private String example;

	public String getExample() {
		return this.example;
	}

	public void setExample(String example) {
		this.example = example;
	}

}
