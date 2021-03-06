package ${variables.rootPackage}.${variables.component}.dataaccess.api;

import ${variables.rootPackage}.${variables.component}.common.api.${variables.entityName};
import ${variables.rootPackage}.general.dataaccess.api.ApplicationPersistenceEntity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Transient;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

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
	<#if property.name != "id">
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
		<#if property.isEntity>
			<#if property.sameComponent>
	private ${OaspUtil.getOaspTypeFromOpenAPI(property, false, false)}Entity ${property.name};
	  	<#else>
	private ${OaspUtil.getOaspTypeFromOpenAPI(property, true, false)} ${property.name}Id;
	  	</#if>
    <#else>
  private ${OaspUtil.getOaspTypeFromOpenAPI(property, false, false)} ${property.name};   
    </#if>
	</#if>
</#list>

<#list model.properties as property>
	<#if property.name != "id">
		<#if property.isEntity && !property.sameComponent>
	public ${OaspUtil.getOaspTypeFromOpenAPI(property, true, false)} get${property.name?cap_first}Id() {
		return this.${property.name}Id;
	}
	
	public void set${property.name?cap_first}Id(${OaspUtil.getOaspTypeFromOpenAPI(property, true, false)} ${property.name}Id) {
		this.${property.name}Id = ${property.name}Id;
	}
		<#elseif property.isEntity && property.sameComponent>
	public ${OaspUtil.getOaspTypeFromOpenAPI(property, false, false)}Entity get${property.name?cap_first}() {
		return this.${property.name};
	}
	
	public void set${property.name?cap_first}(${OaspUtil.getOaspTypeFromOpenAPI(property, false, false)}Entity ${property.name}) {
		this.${property.name} = ${property.name};
	}
		<#elseif !property.isEntity>
	public ${OaspUtil.getOaspTypeFromOpenAPI(property, false, false)} get${property.name?cap_first}() {
		return this.${property.name};
	}
	
	public void set${property.name?cap_first}(${OaspUtil.getOaspTypeFromOpenAPI(property, false, false)} ${property.name}) {
		this.${property.name} = ${property.name};
	}	
		</#if>
	</#if>
	
</#list>

<#list model.properties as property>
	<#if !property.isCollection && property.isEntity && property.sameComponent>
	@Override
	public void set${property.name?cap_first}Id(${OaspUtil.getOaspTypeFromOpenAPI(property, true, false)} ${property.name}Id) {
		if (${property.name}Id == null) {
          this.${property.name} = null;
        } else {
          ${property.type}Entity ${property.type?uncap_first}Entity = new ${property.type}Entity();
          ${property.type?uncap_first}Entity.setId(${property.name}Id);
          this.${property.name} = ${property.type?uncap_first}Entity;
        }
	}
	
	@Override
	@Transient
	public ${OaspUtil.getOaspTypeFromOpenAPI(property, true, false)} get${property.name?cap_first}Id() {
		if (this.${property.name} == null) {
          return null;
        }
        return this.${property.name}.getId();
	}
	</#if>
</#list>

}
