package com.capgemini.demo.samplemanagement.logic.api.to;

import com.capgemini.demo.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Sample
 */
public class SampleCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private SampleEto sample;

  public SampleEto getSample() {

    return sample;
  }

  public void setSample(SampleEto sample) {

    this.sample = sample;
  }

}
