package com.capgemini.devonfw.moredatamanagement.dataaccess.api;

import javax.persistence.Entity;

import com.capgemini.devonfw.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.devonfw.moredatamanagement.common.api.MoreData;

@Entity
@javax.persistence.Table(name = "MOREDATA")
public class MoreDataEntity extends ApplicationPersistenceEntity implements MoreData {

  private String product;

  private String description;

  private Long stock;

  private static final long serialVersionUID = 1L;

  @Override
  public String getProduct() {

    return this.product;
  }

  @Override
  public void setProduct(String product) {

    this.product = product;

  }

  @Override
  public String getDescription() {

    return this.description;
  }

  @Override
  public void setDescription(String description) {

    this.description = description;

  }

  @Override
  public Long getStock() {

    return this.stock;
  }

  @Override
  public void setStock(Long stock) {

    this.stock = stock;

  }

}
