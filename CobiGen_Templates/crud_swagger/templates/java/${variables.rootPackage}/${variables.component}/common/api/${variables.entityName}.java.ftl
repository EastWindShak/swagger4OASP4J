package ${variables.rootPackage}.${variables.component}.common.api;

import ${variables.rootPackage}.general.common.api.ApplicationEntity;
import java.util.List;
import java.util.Set;

public interface ${variables.entityName} extends ApplicationEntity {

<#list model.properties as property>
	public void set<#if property.isEntity>${property.name?cap_first}Id<#else>${property.name?cap_first}</#if>(${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, true)} <#if property.isEntity>${property.name}Id<#else>${property.name}</#if>);
	
	public ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, true)} get<#if property.isEntity>${property.name?cap_first}Id<#else>${property.name?cap_first}</#if>();
</#list>

}
