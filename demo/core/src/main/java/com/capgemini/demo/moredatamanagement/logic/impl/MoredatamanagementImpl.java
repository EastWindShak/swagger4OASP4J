package com.capgemini.demo.moredatamanagement.logic.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.demo.general.logic.base.AbstractComponentFacade;
import com.capgemini.demo.moredatamanagement.dataaccess.api.MoreDataEntity;
import com.capgemini.demo.moredatamanagement.dataaccess.api.dao.MoreDataDao;
import com.capgemini.demo.moredatamanagement.logic.api.Moredatamanagement;
import com.capgemini.demo.moredatamanagement.logic.api.to.MoreDataEto;
import com.capgemini.demo.moredatamanagement.logic.api.to.MoreDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of Moredatamanagement
 */
@Named
@Transactional
public class MoredatamanagementImpl extends AbstractComponentFacade implements Moredatamanagement {

	/**
	 * Logger instance.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(MoredatamanagementImpl.class);

	/**
	 * @see #getMoreDataDao()
	 */
	@Inject
	private MoreDataDao moredataDao;

	/**
	 * The constructor.
	 */
	public MoredatamanagementImpl() {
		super();
	}

	@Override
	public MoreDataEto findMoreData(Long id) {

		LOG.debug("Get MoreData with id {} from database.", id);
		return getBeanMapper().map(getMoreDataDao().findOne(id), MoreDataEto.class);
	}

	@Override
	public PaginatedListTo<MoreDataEto> findMoreDataEtos(MoreDataSearchCriteriaTo criteria) {

		criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
		PaginatedListTo<MoreDataEntity> moredatas = getMoreDataDao().findMoreDatas(criteria);
		return mapPaginatedEntityList(moredatas, MoreDataEto.class);
	}

	@Override
	public boolean deleteMoreData(Long moredataId) {

		MoreDataEntity moredata = getMoreDataDao().find(moredataId);
		getMoreDataDao().delete(moredata);
		LOG.debug("The moredata with id '{}' has been deleted.", moredataId);
		return true;
	}

	@Override
	public MoreDataEto saveMoreData(MoreDataEto moredata) {

		Objects.requireNonNull(moredata, "moredata");
		MoreDataEntity moredataEntity = getBeanMapper().map(moredata, MoreDataEntity.class);

		// initialize, validate moredataEntity here if necessary
		MoreDataEntity resultEntity = getMoreDataDao().save(moredataEntity);
		LOG.debug("MoreData with id '{}' has been created.", resultEntity.getId());

		return getBeanMapper().map(resultEntity, MoreDataEto.class);
	}

	/**
	 * Returns the field 'moredataDao'.
	 *
	 * @return the {@link MoreDataDao} instance.
	 */
	public MoreDataDao getMoreDataDao() {
		return this.moredataDao;
	}
}
