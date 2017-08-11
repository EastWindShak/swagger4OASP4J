package com.capgemini.demo.sampledatamanagement.dataaccess.api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.capgemini.demo.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.demo.moredatamanagement.dataaccess.api.ModeDataEntity;
import com.capgemini.demo.sampledatamanagement.common.api.SampleData;

/**
 * Description of the object
 */
@Entity
@javax.persistence.Table(name = "SampleData")
public class SampleDataEntity extends ApplicationPersistenceEntity implements SampleData {

	private static final long serialVersionUID = 1L;

	/**
	 * Unique identifier representing a specific SampleData
	 */
	@Max(100)
	@Min(4)
	private Long id;

	/**
	 * Name string.
	 */
	@Size(max = 100, min = 0)
	private String name;

	/**
	 * Surname string.
	 */
	private String surname;

	/**
	 * Age integer.
	 */
	private Integer age;

	/**
	 * Mail string.
	 */
	private String mail;

	private ModeDataEntity data;

	private List<ModeDataEntity> tableList;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ModeDataEntity getData() {
		return this.data;
	}

	public void setData(ModeDataEntity data) {
		this.data = data;
	}

	public List<ModeDataEntity> getTableList() {
		return this.tableList;
	}

	public void setTableList(List<ModeDataEntity> tableList) {
		this.tableList = tableList;
	}

	@Override
	public void setDataId(Long dataId) {
		if (dataId == null) {
			this.data = null;
		} else {
			ModeDataEntity modeDataEntity = new ModeDataEntity();
			modeDataEntity.setId(dataId);
			this.data = modeDataEntity;
		}
	}

	@Override
	@Transient
	public Long getDataId() {
		if (this.data == null) {
			return null;
		}
		return this.data.getId();
	}

}
