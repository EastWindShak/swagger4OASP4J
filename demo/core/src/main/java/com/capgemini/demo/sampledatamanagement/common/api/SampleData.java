package com.capgemini.demo.sampledatamanagement.common.api;

import com.capgemini.demo.general.common.api.ApplicationEntity;

public interface SampleData extends ApplicationEntity {

	public void setId(Long id);

	public Long getId();

	public void setName(String name);

	public String getName();

	public void setSurname(String surname);

	public String getSurname();

	public void setAge(Integer age);

	public Integer getAge();

	public void setMail(String mail);

	public String getMail();

	public void setDataId(Long dataId);

	public Long getDataId();

}
