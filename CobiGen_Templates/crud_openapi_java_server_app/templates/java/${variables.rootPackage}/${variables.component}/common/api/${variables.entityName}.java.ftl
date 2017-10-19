package ${variables.rootPackage}.${variables.component}.common.api;

import ${variables.rootPackage}.general.common.api.ApplicationEntity;
import java.util.List;
import java.util.Set;

public interface ${variables.entityName} extends ApplicationEntity {

<#list model.properties as property>
	<#if property.name != "id">
	public void set${property.name?cap_first}(${OaspUtil.getOaspTypeFromOpenAPI(property, false)} ${property.name});
	
	public ${OaspUtil.getOaspTypeFromOpenAPI(property, false)} <#if property.type == "boolean">is<#else>get</#if>${property.name?cap_first}();
	</#if>
</#list>

<#list model.relationShips as rs>
  <#if rs.sameComponent>
  public <#if rs.type == "manytomany" || rs.type == "onetomany">List<${rs.entity}Entity><#else>${rs.entity}Entity</#if> get${rs.entity}<#if rs.type == "manytomany" || rs.type == "onetomany">s</#if> ();

  public void set${rs.entity}<#if rs.type == "manytomany" || rs.type == "onetomany">s</#if>(<#if rs.type == "manytomany" || rs.type == "onetomany">List<${rs.entity}Entity><#else>${rs.entity}Entity</#if> ${rs.entity?uncap_first}<#if rs.type == "manytomany" || rs.type == "onetomany">s</#if>);
  
  <#else>
  public <#if rs.type == "manytomany" || rs.type == "onetomany">List<Long><#else>Long</#if> get${rs.entity}Id<#if rs.type == "manytomany" || rs.type == "onetomany">s</#if> ();

  public void set${rs.entity}Id<#if rs.type == "manytomany" || rs.type == "onetomany">s</#if>(<#if rs.type == "manytomany" || rs.type == "onetomany">List<Long><#else>Long</#if> ${rs.entity?uncap_first}Id<#if rs.type == "manytomany" || rs.type == "onetomany">s</#if>);
  </#if>
</#list>

}
