package com.capgemini.demo.sampledatamanagement.logic.api.to;

import java.util.List;

import com.capgemini.demo.general.common.api.to.AbstractCto;
import com.capgemini.demo.moredatamanagement.logic.api.to.ModeDataEto;

/**
 * Composite transport object of SampleData
 */
public class SampleDataCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private SampleDataEto sampleData;

	private ModeDataEto data;
	private List<ModeDataEto> tableList;

	public SampleDataEto getSampleData() {
		return sampleData;
	}

	public void setSampleData(SampleDataEto sampleData) {
		this.sampleData = sampleData;
	}

	public ModeDataEto getData() {
		return this.data;
	}

	public void setData(ModeDataEto data) {
		this.data = data;
	}

	public List<ModeDataEto> getTableList() {
		return this.tableList;
	}

	public void setTableList(List<ModeDataEto> tableList) {
		this.tableList = tableList;
	}

}
