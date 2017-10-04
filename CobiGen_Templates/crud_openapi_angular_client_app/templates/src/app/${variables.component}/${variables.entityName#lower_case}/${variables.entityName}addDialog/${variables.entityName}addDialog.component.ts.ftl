import { Component, Inject } from '@angular/core';
import { MdDialogRef, MD_DIALOG_DATA } from '@angular/material';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-${variables.entityName?lower_case}-add-dialog',
  templateUrl: './${variables.entityName}addDialog.component.html'
})

export class ${variables.entityName?cap_first}AddDialogComponent {
  items: any;
  title: string;

  constructor(public dialogRef: MdDialogRef<${variables.entityName?cap_first}AddDialogComponent>,
              private translate: TranslateService,
              @Inject(MD_DIALOG_DATA) dialogData: any) {
                if (!dialogData) {
                  this.title = this.getTranslation('${variables.component}.addTitle');
                  this.items = {
                  <#list model.properties as property>
                      <#if property?has_next>
                    ${property.name}: '',
                      <#else>
                    ${property.name}: ''
                     </#if>
                    </#list>
                  };
                } else {
                  this.title = this.getTranslation('${variables.component}.editTitle');
                  this.items = dialogData;
                }
  }

  getTranslation(text: string): string {
    let value: string;
    this.translate.get(text).subscribe( (res) => {
        value = res;
    });
    return value;
  }
}
