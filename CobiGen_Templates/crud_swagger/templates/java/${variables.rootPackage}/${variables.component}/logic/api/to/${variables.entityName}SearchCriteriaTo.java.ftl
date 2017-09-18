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
	<#if !property.isCollection>
	private ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, true, false)} <#if property.isEntity>${property.name}Id<#else>${property.name}</#if>;
	</#if>
</#list>

  /**
  * The constructor.
  */
  public ${variables.entityName}SearchCriteriaTo() {

    super();
  }

<#list model.properties as property>
	<#if !property.isCollection && !property.isEntity>
	public ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false, false)} get${property.name?cap_first}() {
		return this.${property.name};
	}
	
	public void set${property.name?cap_first}(${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false, false)} ${property.name}) {
		this.${property.name} = ${property.name};
	}
	</#if>
</#list>

<#list model.properties as property>
	<#if !property.isCollection && property.isEntity>
	public void set${property.name?cap_first}Id(${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, true, false)} ${property.name}Id) {
		this.${property.name}Id = ${property.name}Id;
	}
	
	public ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, true, false)} get${property.name?cap_first}Id() {
        return this.${property.name}Id;
	}
	<#else>
	
	</#if>
</#list>

}
