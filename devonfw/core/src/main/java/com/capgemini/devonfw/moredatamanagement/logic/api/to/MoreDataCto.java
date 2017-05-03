package com.capgemini.devonfw.moredatamanagement.logic.api.to;

import com.capgemini.devonfw.general.common.api.to.AbstractCto;

/**
 * Composite transport object of MoreData
 */
public class MoreDataCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private MoreDataEto moreData;

  public MoreDataEto getMoreData() {

    return moreData;
  }

  public void setMoreData(MoreDataEto moreData) {

    this.moreData = moreData;
  }

}
