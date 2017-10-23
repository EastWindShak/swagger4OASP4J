package com.capgemini.demo.sampledatamanagement.logic.api.to;

import com.capgemini.demo.general.common.api.to.AbstractEto;
import com.capgemini.demo.sampledatamanagement.common.api.RestaurantTable;

/**
 * Entity transport object of RestaurantTable
 */
public class RestaurantTableEto extends AbstractEto implements RestaurantTable {

	private static final long serialVersionUID = 1L;
	private Integer seats;

	public Integer getSeats() {
		return this.seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.seats == null) ? 0 : this.seats.hashCode());
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
		RestaurantTableEto other = (RestaurantTableEto) obj;
		if (this.seats == null) {
			if (other.seats != null) {
				return false;
			}
		} else if (!this.seats.equals(other.seats)) {
			return false;
		}
		return true;
	}
}
