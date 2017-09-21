package com.capgemini.demo.moredatamanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.capgemini.demo.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.capgemini.demo.moredatamanagement.dataaccess.api.MoreDataEntity;
import com.capgemini.demo.moredatamanagement.dataaccess.api.dao.MoreDataDao;
import com.capgemini.demo.moredatamanagement.logic.api.to.MoreDataSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link MoreDataDao}.
 */
@Named
public class MoreDataDaoImpl extends ApplicationDaoImpl<MoreDataEntity> implements MoreDataDao {

	/**
	 * The constructor.
	 */
	public MoreDataDaoImpl() {

		super();
	}

	@Override
	public Class<MoreDataEntity> getEntityClass() {
		return MoreDataEntity.class;
	}

	@Override
	public PaginatedListTo<MoreDataEntity> findMoreDatas(MoreDataSearchCriteriaTo criteria) {

		MoreDataEntity moredata = Alias.alias(MoreDataEntity.class);
		EntityPathBase<MoreDataEntity> alias = Alias.$(moredata);
		JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

		query.where(Alias.$(moredata.getExample()).eq(criteria.getExample()));
		return findPaginated(criteria, query, alias);
	}

}