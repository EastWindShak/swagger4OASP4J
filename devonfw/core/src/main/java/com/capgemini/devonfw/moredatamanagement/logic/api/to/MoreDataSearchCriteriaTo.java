package com.capgemini.devonfw.moredatamanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.capgemini.devonfw.moredatamanagement.common.api.MoreData}s.
 *
 */
public class MoreDataSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String product;

  private String description;

  private Long stock;

  /**
   * The constructor.
   */
  public MoreDataSearchCriteriaTo() {

    super();
  }

  public String getProduct() {

    return product;
  }

  public void setProduct(String product) {

    this.product = product;
  }

  public String getDescription() {

    return description;
  }

  public void setDescription(String description) {

    this.description = description;
  }

  public Long getStock() {

    return stock;
  }

  public void setStock(Long stock) {

    this.stock = stock;
  }

}
