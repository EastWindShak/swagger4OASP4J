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
    "${variables.etoName}": {
      "navData": "${variables.etoName}_EN",
      "navDataSub": "Grid of ${variables.etoName}_EN",
      "title": "${variables.etoName?cap_first}_EN grid",
      "columns": {
        <#list pojo.fields as field>
          <#if field?has_next>
        "${field.name}": "${field.name?cap_first}_EN",
          <#else>
        "${field.name}": "${field.name?cap_first}_EN"
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
