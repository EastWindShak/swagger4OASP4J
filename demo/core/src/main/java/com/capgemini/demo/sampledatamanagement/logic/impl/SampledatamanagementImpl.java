package com.capgemini.demo.sampledatamanagement.logic.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.demo.general.logic.base.AbstractComponentFacade;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.SampleDataEntity;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.TableEntity;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.dao.SampleDataDao;
import com.capgemini.demo.sampledatamanagement.dataaccess.api.dao.TableDao;
import com.capgemini.demo.sampledatamanagement.logic.api.Sampledatamanagement;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataEto;
import com.capgemini.demo.sampledatamanagement.logic.api.to.SampleDataSearchCriteriaTo;
import com.capgemini.demo.sampledatamanagement.logic.api.to.TableEto;
import com.capgemini.demo.sampledatamanagement.logic.api.to.TableSearchCriteriaTo;

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
	 * @see #getTableDao()
	 */
	@Inject
	private TableDao tableDao;

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
	public TableEto findTable(Long id) {

		LOG.debug("Get Table with id {} from database.", id);
		return getBeanMapper().map(getTableDao().findOne(id), TableEto.class);
	}

	@Override
	public PaginatedListTo<TableEto> findTableEtos(TableSearchCriteriaTo criteria) {

		criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
		PaginatedListTo<TableEntity> tables = getTableDao().findTables(criteria);
		return mapPaginatedEntityList(tables, TableEto.class);
	}

	@Override
	public boolean deleteTable(Long tableId) {

		TableEntity table = getTableDao().find(tableId);
		getTableDao().delete(table);
		LOG.debug("The table with id '{}' has been deleted.", tableId);
		return true;
	}

	@Override
	public TableEto saveTable(TableEto table) {

		Objects.requireNonNull(table, "table");
		TableEntity tableEntity = getBeanMapper().map(table, TableEntity.class);

		// initialize, validate tableEntity here if necessary
		TableEntity resultEntity = getTableDao().save(tableEntity);
		LOG.debug("Table with id '{}' has been created.", resultEntity.getId());

		return getBeanMapper().map(resultEntity, TableEto.class);
	}

	/**
	 * Returns the field 'tableDao'.
	 *
	 * @return the {@link TableDao} instance.
	 */
	public TableDao getTableDao() {
		return this.tableDao;
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
