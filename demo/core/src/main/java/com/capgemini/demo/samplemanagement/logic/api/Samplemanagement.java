package com.capgemini.demo.samplemanagement.logic.api;

import com.capgemini.demo.samplemanagement.logic.api.to.SampleEto;
import com.capgemini.demo.samplemanagement.logic.api.to.SampleSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Samplemanagement component.
 */
public interface Samplemanagement {

  /**
   * Returns a Sample by its id 'id'.
   *
   * @param id The id 'id' of the Sample.
   * @return The {@link SampleEto} with id 'id'
   */
  SampleEto findSample(Long id);

  /**
   * Returns a paginated list of Samples matching the search criteria.
   *
   * @param criteria the {@link SampleSearchCriteriaTo}.
   * @return the {@link List} of matching {@link SampleEto}s.
   */
  PaginatedListTo<SampleEto> findSampleEtos(SampleSearchCriteriaTo criteria);

  /**
   * Deletes a sample from the database by its id 'sampleId'.
   *
   * @param sampleId Id of the sample to delete
   * @return boolean <code>true</code> if the sample can be deleted, <code>false</code> otherwise
   */
  boolean deleteSample(Long sampleId);

  /**
   * Saves a sample and store it in the database.
   *
   * @param sample the {@link SampleEto} to create.
   * @return the new {@link SampleEto} that has been saved with ID and version.
   */
  SampleEto saveSample(SampleEto sample);

}
