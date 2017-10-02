package com.capgemini.demo.sampledatamanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.capgemini.demo.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.TableEntity;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.dao.TableDao;
import com.capgemini.demo.sampledatamanagement.logic.api.to.TableSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link TableDao}.
 */
@Named
public class TableDaoImpl extends ApplicationDaoImpl<TableEntity> implements TableDao {

	/**
	 * The constructor.
	 */
	public TableDaoImpl() {

		super();
	}

	@Override
	public Class<TableEntity> getEntityClass() {
		return TableEntity.class;
	}

	@Override
	public PaginatedListTo<TableEntity> findTables(TableSearchCriteriaTo criteria) {

		TableEntity table = Alias.alias(TableEntity.class);
		EntityPathBase<TableEntity> alias = Alias.$(table);
		JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

		Integer seats = criteria.getSeats();
		if (seats != null) {
			query.where(Alias.$(table.getSeats()).eq(seats));
		}
		return findPaginated(criteria, query, alias);
	}

}