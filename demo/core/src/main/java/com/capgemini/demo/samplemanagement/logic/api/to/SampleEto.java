package com.capgemini.demo.samplemanagement.logic.api.to;


import com.capgemini.demo.general.common.api.to.AbstractEto;
import com.capgemini.demo.samplemanagement.common.api.Sample;

/**
 * Entity transport object of Sample
 */
public class SampleEto extends AbstractEto implements Sample {

  private static final long serialVersionUID = 1L;

  private String name;

  private String surname;

  private Long age;

  private String mail;

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
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.surname == null) ? 0 : this.surname.hashCode());
    result = prime * result + ((this.age == null) ? 0 : this.age.hashCode());
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
    SampleEto other = (SampleEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.surname == null) {
      if (other.surname != null) {
        return false;
      }
    } else if (!this.surname.equals(other.surname)) {
      return false;
    }
    if (this.age == null) {
      if (other.age != null) {
        return false;
      }
    } else if (!this.age.equals(other.age)) {
      return false;
    }
    return true;
  }

  @Override
  public String getMail() {

    return mail;
  }

  @Override
  public void setMail(String mail) {

    this.mail = mail;
  }

}
