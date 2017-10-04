package com.capgemini.demo.sampledatamanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.capgemini.demo.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.RestaurantTableEntity;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.dao.RestaurantTableDao;
import com.capgemini.demo.sampledatamanagement.logic.api.to.RestaurantTableSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link RestaurantTableDao}.
 */
@Named
public class RestaurantTableDaoImpl extends ApplicationDaoImpl<RestaurantTableEntity> implements RestaurantTableDao {

	/**
	 * The constructor.
	 */
	public RestaurantTableDaoImpl() {

		super();
	}

	@Override
	public Class<RestaurantTableEntity> getEntityClass() {
		return RestaurantTableEntity.class;
	}

	@Override
	public PaginatedListTo<RestaurantTableEntity> findRestaurantTables(RestaurantTableSearchCriteriaTo criteria) {

		RestaurantTableEntity restauranttable = Alias.alias(RestaurantTableEntity.class);
		EntityPathBase<RestaurantTableEntity> alias = Alias.$(restauranttable);
		JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

		Integer seats = criteria.getSeats();
		if (seats != null) {
			query.where(Alias.$(restauranttable.getSeats()).eq(seats));
		}
		return findPaginated(criteria, query, alias);
	}

}