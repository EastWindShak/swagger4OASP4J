package com.capgemini.demo.samplemanagement.common.api;

import com.capgemini.demo.general.common.api.ApplicationEntity;

public interface Sample extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getSurname();

  public void setSurname(String surname);

  public Long getAge();

  public void setAge(Long age);

  public String getMail();

  public void setMail(String mail);

}
