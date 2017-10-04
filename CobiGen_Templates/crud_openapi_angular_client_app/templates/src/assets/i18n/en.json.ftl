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
  "${variables.component}": {
    "${variables.entityName}": {
    	"title": "${variables.entityName?cap_first}_EN grid",
    	"navData": "${variables.entityName}_EN",
        "navDataSub": "Grid of ${variables.entityName}_EN",
    	"columns": {
        <#list model.properties as property>
          <#if property?has_next>
           "${property.name}": "${property.name?cap_first}_EN",
          <#else>
           "${property.name}": "${property.name?cap_first}_EN"
          </#if>
        </#list>
        }
    },
    "addTitle": "Add new item",
    "editTitle": "Edit item",
    "searchTip": "Search Panel",
    "sortTip": "Clear Sorting",
    "alert": {
      "title": "Confirm",
      "message": "Are you sure you want to delete this item?",
      "cancelBtn": "No, Cancel",
      "acceptBtn": "Yes, Delete"
    }
  }
}
