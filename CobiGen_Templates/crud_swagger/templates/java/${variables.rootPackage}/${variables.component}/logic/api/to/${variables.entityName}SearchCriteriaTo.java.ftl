package ${variables.rootPackage}.${variables.component}.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;
import java.util.List;
import java.util.Set;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link ${variables.rootPackage}.${variables.component}.common.api.${variables.entityName}}s.
 *
 */
public class ${variables.entityName}SearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;
  
<#list model.properties as property>
	<#if property.constraints.maximum??>
  @Max(${property.constraints.maximum})
	</#if>
	<#if property.constraints.minimum??>
  @Min(${property.constraints.minimum})
	</#if>
	<#if property.required>
  @NotNull
	</#if>
	<#if property.constraints.maxLength?? && !property.constraints.minLength??>
  @Size(max = ${property.constraints.maxLength})
	<#elseif !property.constraints.maxLength?? && property.constraints.minLength??>
  @Size(min = ${property.constraints.minLength})
	<#elseif property.constraints.maxLength?? && property.constraints.minLength??>
  @Size(max = ${property.constraints.maxLength}, min = ${property.constraints.minLength})	
	</#if>
  private ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false)} ${property.name};
</#list>

  /**
  * The constructor.
  */
  public ${variables.entityName}SearchCriteriaTo() {

    super();
  }

<#list model.properties as property>
  public void set${property.name?cap_first}(${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false)} ${property.name}) {
	this.${property.name} = ${property.name};
  }
	
  public ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false)} get${property.name?cap_first}() {
	return this.${property.name};
  }
</#list>

}
