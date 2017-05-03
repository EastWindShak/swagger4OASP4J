package com.capgemini.devonfw.sampledatamanagement.logic.api.to;

import com.capgemini.devonfw.general.common.api.to.AbstractCto;

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
