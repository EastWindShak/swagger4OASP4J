import { Component, Inject } from '@angular/core';
import { MdDialogRef, MD_DIALOG_DATA } from '@angular/material';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-sampledatamanagement-add-dialog',
  templateUrl: './sampledatamanagementaddDialog.component.html'
})

export class SampledatamanagementAddDialogComponent {
  items: any;
  title: string;

  constructor(public dialogRef: MdDialogRef<SampledatamanagementAddDialogComponent>,
              private translate: TranslateService,
              @Inject(MD_DIALOG_DATA) dialogData: any) {
                if (!dialogData) {
                  this.title = this.getTranslation('sampledatamanagementdatagrid.addTitle');
                  this.items = {
                    name: '',
                    surname: '',
                    age: '',
                    mail: ''
                  };
                } else {
                  this.title = this.getTranslation('sampledatamanagementdatagrid.editTitle');
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
