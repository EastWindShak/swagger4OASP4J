package ${variables.rootPackage}.${variables.component}.dataaccess.api;

import ${variables.rootPackage}.${variables.component}.common.api.${variables.entityName};
import ${variables.rootPackage}.general.dataaccess.api.ApplicationPersistenceEntity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Transient;

<#if model.description??>
/**
 * ${model.description}
 */
 <#else>
 /**
 * Data access object for ${variables.entityName} entities
 */
 </#if>
@Entity
@javax.persistence.Table(name = "${variables.entityName}")
public class ${variables.entityName?cap_first}Entity extends ApplicationPersistenceEntity implements ${variables.entityName} {

  private static final long serialVersionUID = 1L;

<#list model.properties as property>
	<#if property.description??>
	/**
	* ${property.description}
	*/
	</#if>
	<#if property.constraints.maximum??>
	@Max(${property.constraints.maximum})
	</#if>
	<#if property.constraints.minimum??>
	@Min(${property.constraints.minimum})
	</#if>
	<#if property.required>
	${property.required?c}
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

<#list model.properties as property>
	@Override
	public void set${property.name?cap_first}(${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false)} ${property.name}) {
		this.${property.name} = ${property.name};
	}
	
	@Override
	public ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false)} get${property.name?cap_first}() {
		return this.${property.name};
	}
</#list>

}
