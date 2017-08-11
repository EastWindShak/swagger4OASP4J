package com.capgemini.demo.moredatamanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.capgemini.demo.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.capgemini.demo.moredatamanagement.dataaccess.api.ModeDataEntity;
import com.capgemini.demo.moredatamanagement.dataaccess.api.dao.ModeDataDao;
import com.capgemini.demo.moredatamanagement.logic.api.to.ModeDataSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link ModeDataDao}.
 */
@Named
public class ModeDataDaoImpl extends ApplicationDaoImpl<ModeDataEntity> implements ModeDataDao {

	/**
	 * The constructor.
	 */
	public ModeDataDaoImpl() {

		super();
	}

	@Override
	public Class<ModeDataEntity> getEntityClass() {
		return ModeDataEntity.class;
	}

	@Override
	public PaginatedListTo<ModeDataEntity> findModeDatas(ModeDataSearchCriteriaTo criteria) {

		ModeDataEntity modedata = Alias.alias(ModeDataEntity.class);
		EntityPathBase<ModeDataEntity> alias = Alias.$(modedata);
		JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

		String example = criteria.getExample();
		if (example != null) {
			query.where(Alias.$(modedata.getExample()).eq(example));
		}
		return findPaginated(criteria, query, alias);
	}

}