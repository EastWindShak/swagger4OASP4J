{
"buttons": {
  "submit": "Enviar",
  "close": "Cerrar",
  "cancel": "CANCELAR",
  "save": "GUARDAR",
  "search": "BUSCAR",
  "clean": "LIMPIAR",
  "addItem": "Añadir fila",
  "editItem": "Editar fila",
  "deleteItem": "Eliminar fila"
},
  "header": {
    "title": "Aplicacion Angular de ${variables.domain}",
    "error": "Error de acceso"
  },
  "login": {
    "title": "Acceso",
    "username": "Nombre de usuario",
    "password": "Contraseña",
    "errorMsg": "Nombre de usuario o contraseña incorrectos"
  },
  "home": "Inicio",
  "${variables.component}": {
    "${variables.entityName}": {
    	"title": "${variables.entityName?cap_first}_ES grid",
    	"navData": "${variables.entityName}_ES",
        "navDataSub": "Tabla de ${variables.entityName}_ES",
    	"columns": {
        <#list model.properties as property>
          <#if property?has_next>
           "${property.name}": "${property.name?cap_first}_ES",
          <#else>
           "${property.name}": "${property.name?cap_first}_ES"
          </#if>
        </#list>
        }
    },
    "addtitle": "Añadir nueva fila",
    "editTitle": "Editar fila existente",
    "searchTip": "Panel de búsqueda",
    "sortTip": "Limpiar Ordenación",
    "alert": {
      "title": "Confirmación",
      "message": "¿Seguro que deseas eliminar esta fila?",
      "cancelBtn": "No, Cancelar",
      "acceptBtn": "Sí, Eliminar"
    }
  }
}
