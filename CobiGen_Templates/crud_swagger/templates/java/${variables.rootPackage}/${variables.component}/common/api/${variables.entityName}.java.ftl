package ${variables.rootPackage}.${variables.component}.common.api;

import ${variables.rootPackage}.general.common.api.ApplicationEntity;
import java.util.List;
import java.util.Set;

public interface ${variables.entityName} extends ApplicationEntity {

<#list model.properties as property>
	<#if property.name != "id">
		<#if !property.isCollection>
	public void set<#if property.isEntity>${property.name?cap_first}Id<#else>${property.name?cap_first}</#if>(${OaspUtil.getOaspTypeFromOpenAPI(property, true, true)} <#if property.isEntity>${property.name}Id<#else>${property.name}</#if>);
	
	public ${OaspUtil.getOaspTypeFromOpenAPI(property, true, true)} get<#if property.isEntity>${property.name?cap_first}Id<#else>${property.name?cap_first}</#if>();
		</#if>
	</#if>
</#list>

}
