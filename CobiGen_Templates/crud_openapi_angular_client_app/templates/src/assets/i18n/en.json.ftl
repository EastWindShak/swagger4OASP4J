{
"buttons": {
    "submit": "Send",
    "search": "SEARCH",
    "cancel": "CANCEL",
    "save": "SAVE",
    "clean": "CLEAR",
    "close": "Close",
    "addItem": "Add item",
    "editItem": "Edit item",
    "deleteItem": "Delete item"
  },
  "header": {
    "title": "${variables.domain} Angular application",
    "error": "LOGIN ERROR"
  },
  "login": {
    "title": "Login",
    "username": "Username",
    "password": "Password",
    "errorMsg": "Wrong username or password"
  },
  "home": "Home",
  "${variables.component}datagrid": {
    "navData": "${variables.entityName}_EN",
    "navDataSub": "Grid of ${variables.entityName}_EN",
    "title": "${variables.entityName?cap_first}_EN grid",
    "addTitle": "Add new item",
    "editTitle": "Edit item",
    "searchTip": "Search Panel",
    "sortTip": "Clear Sorting",
    "columns": {
      <#list model.properties as property>
        <#if property?has_next>
      "${property.name}": "${property.name?cap_first}_EN",
        <#else>
      "${property.name}": "${property.name?cap_first}_EN"
        </#if>
      </#list>
    },
    "alert": {
      "title": "Confirm",
      "message": "Are you sure you want to delete this item?",
      "cancelBtn": "No, Cancel",
      "acceptBtn": "Yes, Delete"
    }
  }
}
