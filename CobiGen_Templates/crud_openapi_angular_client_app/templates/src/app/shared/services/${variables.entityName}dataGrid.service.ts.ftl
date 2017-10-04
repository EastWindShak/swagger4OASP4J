import { TranslateService } from '@ngx-translate/core';
import { ITdDataTableColumn } from '@covalent/core';
import { Injectable } from '@angular/core'
import { HttpClient } from '../security/httpClient.service';
import { BusinessOperations } from '../../BusinessOperations';

@Injectable()
export class ${variables.entityName?cap_first}DataGridService {

    constructor(private BO: BusinessOperations,
                private http: HttpClient) {
    }

    getData(size: number, page: number, searchTerms, sort: any[]) {
      let pageData = {
        pagination: {
          size: size,
          page: page,
          total: 1
        },
        <#list model.properties as property>
        ${property.name}: searchTerms.${property.name},
        </#list>
        sort: sort
      }
      return this.http.post(this.BO.post${variables.entityName?cap_first}Search(), pageData)
                      .map(res => res.json());
    }

    saveData(data) {
      let obj = {
        id: data.id,
        <#list model.properties as property>
          <#if property?has_next>
        ${property.name}: data.${property.name},
          <#else>
        ${property.name}: data.${property.name}
         </#if>
        </#list>
      };

      return this.http.post(this.BO.post${variables.entityName?cap_first}(),  obj ).map(res => res.json());
    }

    deleteData(id) {
      return this.http.delete(this.BO.delete${variables.entityName?cap_first}() + id)
    }

    searchData(criteria) {
      return this.http.post(this.BO.post${variables.entityName?cap_first}Search(), { criteria: criteria }).map(res => res.json());
    }

}
