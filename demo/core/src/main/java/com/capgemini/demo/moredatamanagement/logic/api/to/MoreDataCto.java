package com.capgemini.demo.moredatamanagement.logic.api.to;

import com.capgemini.demo.general.common.api.to.AbstractCto;
import com.capgemini.demo.moredatamanagement.common.api.MoreData;

/**
 * Composite transport object of MoreData
 */
public class MoreDataCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private MoreDataEto moreData;

	public MoreData getMoreData() {
		return moreData;
	}

	public void setMoreData(MoreDataEto moreData) {
		this.moreData = moreData;
	}

}
