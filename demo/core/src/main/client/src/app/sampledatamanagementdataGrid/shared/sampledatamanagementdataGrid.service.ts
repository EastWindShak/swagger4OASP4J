import { TranslateService } from '@ngx-translate/core';
import { ITdDataTableColumn } from '@covalent/core';
import { Injectable } from '@angular/core'
import { HttpClient } from '../../shared/security/httpClient.service';
import { BusinessOperations } from '../../BusinessOperations';

@Injectable()
export class SampledatamanagementDataGridService {

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
        name: searchTerms.name,
        surname: searchTerms.surname,
        age: searchTerms.age,
        mail: searchTerms.mail,
        sort: sort
      }
      return this.http.post(this.BO.postSampleDataSearch(), pageData)
                      .map(res => res.json());
    }

    saveData(data) {
      let obj = {
        id: data.id,
        name: data.name,
        surname: data.surname,
        age: data.age,
        mail: data.mail
      };

      return this.http.post(this.BO.postSampleData(),  obj ).map(res => res.json());
    }

    deleteData(id) {
      return this.http.delete(this.BO.deleteSampleData() + id)
    }

    searchData(criteria) {
      return this.http.post(this.BO.postSampleDataSearch(), { criteria: criteria }).map(res => res.json());
    }

}
