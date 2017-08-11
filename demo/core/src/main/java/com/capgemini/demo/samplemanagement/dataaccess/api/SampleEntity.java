package com.capgemini.demo.samplemanagement.dataaccess.api;

import javax.persistence.Entity;

import com.capgemini.demo.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.demo.samplemanagement.common.api.Sample;

@Entity
@javax.persistence.Table(name = "SAMPLE")
public class SampleEntity extends ApplicationPersistenceEntity implements Sample {

  private static final long serialVersionUID = 1L;

  private String name;

  private String surname;

  private Long age;

  private String mail;

  public String getMail() {

    return this.mail;
  }

  public void setMail(String mail) {

    this.mail = mail;
  }

  public String getName() {

    return this.name;
  }

  public void setName(String name) {

    this.name = name;

  }

  public String getSurname() {

    return this.surname;
  }

  public void setSurname(String surname) {

    this.surname = surname;

  }

  public Long getAge() {

    return this.age;
  }

  public void setAge(Long age) {

    this.age = age;

  }

}
