package com.capgemini.devonfw.sampledatamanagement.dataaccess.api;

import javax.persistence.Entity;

import com.capgemini.devonfw.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.devonfw.sampledatamanagement.common.api.SampleData;

@Entity
@javax.persistence.Table(name = "SAMPLEDATA")
public class SampleDataEntity extends ApplicationPersistenceEntity implements SampleData {

  private String name;

  private String surname;

  private Long age;

  private String mail;

  private static final long serialVersionUID = 1L;

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;

  }

  @Override
  public String getSurname() {

    return this.surname;
  }

  @Override
  public void setSurname(String surname) {

    this.surname = surname;

  }

  @Override
  public Long getAge() {

    return this.age;
  }

  @Override
  public void setAge(Long age) {

    this.age = age;

  }

  @Override
  public String getMail() {

    return this.mail;
  }

  @Override
  public void setMail(String mail) {

    this.mail = mail;

  }

}
