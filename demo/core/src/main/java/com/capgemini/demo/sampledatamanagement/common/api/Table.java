package com.capgemini.demo.sampledatamanagement.common.api;

import com.capgemini.demo.general.common.api.ApplicationEntity;

public interface Table extends ApplicationEntity {

	public void setExample(String example);

	public String getExample();

}