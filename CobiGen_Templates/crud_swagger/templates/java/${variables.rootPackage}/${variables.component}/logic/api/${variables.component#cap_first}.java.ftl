package ${variables.rootPackage}.${variables.component}.logic.api;

import ${variables.rootPackage}.${variables.component}.logic.api.to.${variables.entityName}Eto;
import ${variables.rootPackage}.${variables.component}.logic.api.to.${variables.entityName}SearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for ${variables.component?cap_first} component.
 */
public interface ${variables.component?cap_first} {
  
  <#list model.component.paths as path>
  	<#if path.path.get??>
  		${path.path.get}
  	</#if>
  </#list>

}