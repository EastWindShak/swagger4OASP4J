package com.capgemini.devonfw.general.common.api.constants;

import io.oasp.module.security.common.api.accesscontrol.AccessControlPermission;

/**
 * Contains constants for the keys of all {@link AccessControlPermission Permission}s.
 */
public abstract class PermissionConstants {

  /** {@link AccessControlPermission Permission} to find sample data. */
  public static final String FIND_SAMPLE_DATA = "FindSampleData";

  /** {@link AccessControlPermission Permission} to save sample data. */
  public static final String SAVE_SAMPLE_DATA = "SaveSampleData";

  /** {@link AccessControlPermission Permission} to delete sample data. */
  public static final String DELETE_SAMPLE_DATA = "DeleteSampleData";

  /** {@link AccessControlPermission Permission} to delete moredata. */
  public static final String DELETE_MORE_DATA = "DeleteMoreData";

  /** {@link AccessControlPermission Permission} to save moredata. */
  public static final String SAVE_MORE_DATA = "SaveMoreData";

  /** {@link AccessControlPermission Permission} to find moredata. */
  public static final String FIND_MORE_DATA = "FindMoreData";

}