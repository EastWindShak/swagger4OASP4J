package com.capgemini.demo.moredatamanagement.logic.api.to;

import com.capgemini.demo.general.common.api.to.AbstractCto;

/**
 * Composite transport object of ModeData
 */
public class ModeDataCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private ModeDataEto modeData;

	public ModeDataEto getModeData() {
		return modeData;
	}

	public void setModeData(ModeDataEto modeData) {
		this.modeData = modeData;
	}

}
