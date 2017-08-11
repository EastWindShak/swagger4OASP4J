package com.capgemini.demo.samplemanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.capgemini.demo.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.capgemini.demo.samplemanagement.dataaccess.api.SampleEntity;
import com.capgemini.demo.samplemanagement.dataaccess.api.dao.SampleDao;
import com.capgemini.demo.samplemanagement.logic.api.to.SampleSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link SampleDao}.
 */
@Named
public class SampleDaoImpl extends ApplicationDaoImpl<SampleEntity> implements SampleDao {

  /**
   * The constructor.
   */
  public SampleDaoImpl() {

    super();
  }

  @Override
  public Class<SampleEntity> getEntityClass() {

    return SampleEntity.class;
  }

  @Override
  public PaginatedListTo<SampleEntity> findSamples(SampleSearchCriteriaTo criteria) {

    SampleEntity sample = Alias.alias(SampleEntity.class);
    EntityPathBase<SampleEntity> alias = Alias.$(sample);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(sample.getName()).eq(name));
    }
    String surname = criteria.getSurname();
    if (surname != null) {
      query.where(Alias.$(sample.getSurname()).eq(surname));
    }
    Long age = criteria.getAge();
    if (age != null) {
      query.where(Alias.$(sample.getAge()).eq(age));
    }
    return findPaginated(criteria, query, alias);
  }

}
