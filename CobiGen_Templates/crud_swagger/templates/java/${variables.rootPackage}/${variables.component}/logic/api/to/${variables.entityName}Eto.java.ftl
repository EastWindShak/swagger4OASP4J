package ${variables.rootPackage}.${variables.component}.logic.api.to;

import ${variables.rootPackage}.general.common.api.to.AbstractEto;
import ${variables.rootPackage}.${variables.component}.common.api.${variables.entityName};

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
/**
 * Entity transport object of ${variables.entityName}
 */
public class ${variables.entityName}Eto extends AbstractEto implements ${variables.entityName} {

	private static final long serialVersionUID = 1L;
<#list model.properties as property>
	<#if !property.isCollection>
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
	private ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, true)} <#if property.isEntity>${property.name}Id<#else>${property.name}</#if>;
	
	</#if>
</#list>

<#list model.properties as property>
	<#if !property.isCollection && !property.isEntity>
	public ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false)} get${property.name?cap_first}() {
		return this.${property.name};
	}
	
	public void set${property.name?cap_first}(${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, false)} ${property.name}) {
		this.${property.name} = ${property.name};
	}
	</#if>
</#list>

<#list model.properties as property>
	<#if !property.isCollection && property.isEntity>
	@Override
	public void set${property.name?cap_first}Id(${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, true)} ${property.name}Id) {
		this.${property.name}Id = ${property.name}Id;
	}
	
	@Override
	public ${OaspUtil.getOaspTypeFromOpenAPI(property.type, property.format, property.isCollection, property.isEntity, true)} get${property.name?cap_first}Id() {
        return this.${property.name}Id;
	}
	<#else>
	
	</#if>
</#list>

}
