package com.capgemini.demo.sampledatamanagement.logic.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.demo.general.logic.base.AbstractComponentFacade;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.SampleDataEntity;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.dao.SampleDataDao;
import com.capgemini.demo.sampledatamanagement.logic.api.Sampledatamanagement;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataEto;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of Sampledatamanagement
 */
@Named
@Transactional
public class SampledatamanagementImpl extends AbstractComponentFacade implements Sampledatamanagement {

	/**
	 * Logger instance.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(SampledatamanagementImpl.class);

	/**
	 * @see #getSampleDataDao()
	 */
	@Inject
	private SampleDataDao sampledataDao;

	/**
	 * The constructor.
	 */
	public SampledatamanagementImpl() {
		super();
	}

	@Override
	public SampleDataEto findSampleData(Long id) {

		LOG.debug("Get SampleData with id {} from database.", id);
		return getBeanMapper().map(getSampleDataDao().findOne(id), SampleDataEto.class);
	}

	@Override
	public PaginatedListTo<SampleDataEto> findSampleDataEtos(SampleDataSearchCriteriaTo criteria) {

		criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
		PaginatedListTo<SampleDataEntity> sampledatas = getSampleDataDao().findSampleDatas(criteria);
		return mapPaginatedEntityList(sampledatas, SampleDataEto.class);
	}

	@Override
	public boolean deleteSampleData(Long sampledataId) {

		SampleDataEntity sampledata = getSampleDataDao().find(sampledataId);
		getSampleDataDao().delete(sampledata);
		LOG.debug("The sampledata with id '{}' has been deleted.", sampledataId);
		return true;
	}

	@Override
	public SampleDataEto saveSampleData(SampleDataEto sampledata) {

		Objects.requireNonNull(sampledata, "sampledata");
		SampleDataEntity sampledataEntity = getBeanMapper().map(sampledata, SampleDataEntity.class);

		// initialize, validate sampledataEntity here if necessary
		SampleDataEntity resultEntity = getSampleDataDao().save(sampledataEntity);
		LOG.debug("SampleData with id '{}' has been created.", resultEntity.getId());

		return getBeanMapper().map(resultEntity, SampleDataEto.class);
	}

	@Override
	public SampleDataEto customMethod(long id) {
		// TODO customMethod
		return null;
	}

	@Override
	public boolean deleteCustomSampleData(long id) {
		// TODO deleteCustomSampleData
		return false;
	}

	@Override
	public PaginatedListTo<SampleDataEto> saveCustomSampleData(SampleDataEto sampleData) {
		// TODO saveCustomSampleData
		return null;
	}

	@Override
	public PaginatedListTo<SampleDataEto> findCustomSampleDataEtos(SampleDataSearchCriteriaTo criteria) {
		// TODO findCustomSampleDataEtos
		return null;
	}

	/**
	 * Returns the field 'sampledataDao'.
	 *
	 * @return the {@link SampleDataDao} instance.
	 */
	public SampleDataDao getSampleDataDao() {
		return this.sampledataDao;
	}
}
