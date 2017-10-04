package com.capgemini.demo.sampledatamanagement.common.api;

import com.capgemini.demo.general.common.api.ApplicationEntity;

public interface RestaurantTable extends ApplicationEntity {

	public void setSeats(Integer seats);

	public Integer getSeats();

}
