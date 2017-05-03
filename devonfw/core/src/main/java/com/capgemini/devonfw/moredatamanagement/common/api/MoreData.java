package com.capgemini.devonfw.moredatamanagement.common.api;

import com.capgemini.devonfw.general.common.api.ApplicationEntity;

public interface MoreData extends ApplicationEntity {

  public String getProduct();

  public void setProduct(String product);

  public String getDescription();

  public void setDescription(String description);

  public Long getStock();

  public void setStock(Long stock);

}
