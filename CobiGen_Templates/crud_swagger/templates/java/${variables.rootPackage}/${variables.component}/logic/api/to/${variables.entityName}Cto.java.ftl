package ${variables.rootPackage}.${variables.component}.logic.api.to;

import ${variables.rootPackage}.general.common.api.to.AbstractCto;
import ${variables.rootPackage}.${variables.component}.common.api.${variables.entityName};

import java.util.List;
import java.util.Set;

/**
 * Composite transport object of ${variables.entityName}
 */
public class ${variables.entityName}Cto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private ${variables.entityName}Eto ${variables.entityName?uncap_first};

<#list model.properties as property>
<#if property.isEntity>
   	private ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false)?replace("Entity", "Eto")} ${property.name};
</#if>
</#list>

	public ${variables.entityName}Eto get${variables.entityName}() {
		return ${variables.entityName?uncap_first};
	}

	public void set${variables.entityName}(${variables.entityName}Eto ${variables.entityName?uncap_first}) {
		this.${variables.entityName?uncap_first} = ${variables.entityName?uncap_first};
	}

<#list model.properties as property>
	<#if property.isEntity>
	public ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false)?replace("Entity", "Eto")} get${property.name?cap_first}() {
		return this.${property.name};
	}
	
	public void set${property.name?cap_first}(${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false)?replace("Entity", "Eto")} ${property.name}) {
		this.${property.name} = ${property.name};
	}
	</#if>
	
</#list>
}
