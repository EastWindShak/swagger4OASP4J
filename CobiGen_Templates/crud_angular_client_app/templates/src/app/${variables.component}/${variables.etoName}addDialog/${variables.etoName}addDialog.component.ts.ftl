import { Component, Inject } from '@angular/core';
import { MdDialogRef, MD_DIALOG_DATA } from '@angular/material';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-${variables.etoName}-add-dialog',
  templateUrl: './${variables.etoName}addDialog.component.html'
})

export class ${variables.etoName?cap_first}AddDialogComponent {
  items: any;
  title: string;

  constructor(public dialogRef: MdDialogRef<${variables.etoName?cap_first}AddDialogComponent>,
              private translate: TranslateService,
              @Inject(MD_DIALOG_DATA) dialogData: any) {
                if (!dialogData) {
                  this.title = this.getTranslation('${variables.component}.addTitle');
                  this.items = {
                  <#list pojo.fields as field>
                      <#if field?has_next>
                    ${field.name}: '',
                      <#else>
                    ${field.name}: ''
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
