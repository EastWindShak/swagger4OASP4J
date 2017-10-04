<#-- ---------------------------------------- -->
<#-- GENERAL JAVA SPECIFIC FUNCTIONS & MACROS -->
<#-- ---------------------------------------- -->

<#function getType simpleType>
    <#if simpleType=="byte">
        <#return "number">
    <#elseif simpleType=="short">
        <#return "number">
    <#elseif simpleType=="int">
        <#return "number">
    <#elseif simpleType=="Integer">
        <#return "number">
    <#elseif simpleType=="long">
        <#return "number">
    <#elseif simpleType=="Double">
        <#return "number">
    <#elseif simpleType=="Long">
        <#return "number">
    <#elseif simpleType=="float">
        <#return "number">
    <#elseif simpleType=="double">
        <#return "number">
    <#elseif simpleType=="boolean">
        <#return "boolean">
    <#elseif simpleType=="Boolean">
        <#return "boolean">
    <#elseif simpleType=="char">
        <#return "string">
    <#elseif simpleType=="String">
        <#return "string">
    <#else>
        <#return "any">
    </#if>
</#function>

<#-- -------------------- -->
<#-- SPECIFIC MACROS -->
<#-- -------------------- -->

<#-- Adds the input fields for the filter with types -->
<#macro getNG2Type_Grid_Search>
  <#list model.properties as property>
      <md-input-container style="width:100%;">
        <input mdInput name ="${property.name}" type="${getType(OaspUtil.getOaspTypeFromOpenAPI(property, false, false))}" ngModel [placeholder]= "'${variables.component}.${variables.entityName}.columns.${property.name}' | translate">
      </md-input-container>
   </#list>
</#macro>

<#-- Adds the input fields for the New Element dialog with types -->
<#macro getNG2Type_Add_Dialog>
  <#list model.properties as property>
    <md-input-container style="width:100%;">
        <input mdInput type="${getType(OaspUtil.getOaspTypeFromOpenAPI(property, false, false))}" name = "${property.name}" [placeholder]= "'${variables.component}.${variables.entityName}.columns.${property.name}' | translate" [(ngModel)] = "items.${property.name}" required>
    </md-input-container>
   </#list>
</#macro>
