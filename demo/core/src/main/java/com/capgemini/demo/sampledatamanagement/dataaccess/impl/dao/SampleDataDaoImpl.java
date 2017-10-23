package com.capgemini.demo.sampledatamanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.capgemini.demo.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.SampleDataEntity;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.dao.SampleDataDao;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link SampleDataDao}.
 */
@Named
public class SampleDataDaoImpl extends ApplicationDaoImpl<SampleDataEntity> implements SampleDataDao {

	/**
	 * The constructor.
	 */
	public SampleDataDaoImpl() {

		super();
	}

	@Override
	public Class<SampleDataEntity> getEntityClass() {
		return SampleDataEntity.class;
	}

	@Override
	public PaginatedListTo<SampleDataEntity> findSampleDatas(SampleDataSearchCriteriaTo criteria) {

		SampleDataEntity sampledata = Alias.alias(SampleDataEntity.class);
		EntityPathBase<SampleDataEntity> alias = Alias.$(sampledata);
		JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

		String name = criteria.getName();
		if (name != null) {
			query.where(Alias.$(sampledata.getName()).eq(name));
		}
		String surname = criteria.getSurname();
		if (surname != null) {
			query.where(Alias.$(sampledata.getSurname()).eq(surname));
		}
		Integer age = criteria.getAge();
		if (age != null) {
			query.where(Alias.$(sampledata.getAge()).eq(age));
		}
		String mail = criteria.getMail();
		if (mail != null) {
			query.where(Alias.$(sampledata.getMail()).eq(mail));
		}
		return findPaginated(criteria, query, alias);
	}

}