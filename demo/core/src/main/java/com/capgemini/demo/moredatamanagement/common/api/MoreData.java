package com.capgemini.demo.moredatamanagement.common.api;

import com.capgemini.demo.general.common.api.ApplicationEntity;

public interface MoreData extends ApplicationEntity {

	public void setExample(String example);

	public String getExample();

	public void setSampleDataId(Long sampleDataId);

	public Long getSampleDataId();

}
