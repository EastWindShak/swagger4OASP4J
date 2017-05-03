package com.capgemini.devonfw.moredatamanagement.logic.api.to;

import com.capgemini.devonfw.general.common.api.to.AbstractEto;
import com.capgemini.devonfw.moredatamanagement.common.api.MoreData;

/**
 * Entity transport object of MoreData
 */
public class MoreDataEto extends AbstractEto implements MoreData {

  private static final long serialVersionUID = 1L;

  private String product;

  private String description;

  private Long stock;

  @Override
  public String getProduct() {

    return product;
  }

  @Override
  public void setProduct(String product) {

    this.product = product;
  }

  @Override
  public String getDescription() {

    return description;
  }

  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  @Override
  public Long getStock() {

    return stock;
  }

  @Override
  public void setStock(Long stock) {

    this.stock = stock;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.product == null) ? 0 : this.product.hashCode());
    result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
    result = prime * result + ((this.stock == null) ? 0 : this.stock.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    MoreDataEto other = (MoreDataEto) obj;
    if (this.product == null) {
      if (other.product != null) {
        return false;
      }
    } else if (!this.product.equals(other.product)) {
      return false;
    }
    if (this.description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!this.description.equals(other.description)) {
      return false;
    }
    if (this.stock == null) {
      if (other.stock != null) {
        return false;
      }
    } else if (!this.stock.equals(other.stock)) {
      return false;
    }
    return true;
  }
}
