package com.capgemini.devonfw.sampledatamanagement.dataaccess.impl.dao;

import static com.mysema.query.alias.Alias.$;

import java.util.List;

import javax.inject.Named;

import com.capgemini.devonfw.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.capgemini.devonfw.sampledatamanagement.dataaccess.api.SampleDataEntity;
import com.capgemini.devonfw.sampledatamanagement.dataaccess.api.dao.SampleDataDao;
import com.capgemini.devonfw.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.OrderByTo;
import io.oasp.module.jpa.common.api.to.OrderDirection;
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
    Long age = criteria.getAge();
    if (age != null) {
      query.where(Alias.$(sampledata.getAge()).eq(age));
    }
    String mail = criteria.getMail();
    if (mail != null) {
      query.where(Alias.$(sampledata.getMail()).eq(mail));
    }

    addOrderBy(query, alias, sampledata, criteria.getSort());
    return findPaginated(criteria, query, alias);
  }

  private void addOrderBy(JPAQuery query, EntityPathBase<SampleDataEntity> alias, SampleDataEntity sampledata,
      List<OrderByTo> sort) {

    if (sort != null && !sort.isEmpty()) {
      for (OrderByTo orderEntry : sort) {
        if ("name".equals(orderEntry.getName())) {

          if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
            query.orderBy($(sampledata.getName()).asc());
          } else {
            query.orderBy($(sampledata.getName()).desc());
          }

        } else if ("surname".equals(orderEntry.getName())) {

          if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
            query.orderBy($(sampledata.getSurname()).asc());
          } else {
            query.orderBy($(sampledata.getSurname()).desc());
          }

        } else if ("age".equals(orderEntry.getName())) {

          if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
            query.orderBy($(sampledata.getAge()).asc());
          } else {
            query.orderBy($(sampledata.getAge()).desc());
          }

        } else if ("mail".equals(orderEntry.getName())) {

          if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
            query.orderBy($(sampledata.getMail()).asc());
          } else {
            query.orderBy($(sampledata.getMail()).desc());
          }

        }

      }
    }

  }

}