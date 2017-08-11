
package com.capgemini.demo.general.common.api.constants;

import io.oasp.module.security.common.api.accesscontrol.AccessControlPermission;

/**
 * Contains constants for the keys of all {@link AccessControlPermission Permission}s.
 */
public abstract class PermissionConstants {

  /** {@link AccessControlPermission Permission} to find sample. */
  public static final String FIND_SAMPLE = "FindSample";

  /** {@link AccessControlPermission Permission} to find more. */
  public static final String FIND_MORE = "FindMore";

  /** {@link AccessControlPermission Permission} to save sample. */
  public static final String SAVE_SAMPLE = "SaveSample";

  /** {@link AccessControlPermission Permission} to delete sample. */
  public static final String DELETE_SAMPLE = "DeleteSample";

}