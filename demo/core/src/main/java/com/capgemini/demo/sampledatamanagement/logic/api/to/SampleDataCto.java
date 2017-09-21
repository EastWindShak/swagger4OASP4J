package com.capgemini.demo.sampledatamanagement.logic.api.to;

import com.capgemini.demo.general.common.api.to.AbstractCto;

/**
 * Composite transport object of SampleData
 */
public class SampleDataCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private SampleDataEto sampleData;

	public SampleDataEto getSampleData() {
		return sampleData;
	}

	public void setSampleData(SampleDataEto sampleData) {
		this.sampleData = sampleData;
	}

}
