import { Router } from '@angular/router';
import { AuthService } from '../shared/security/auth.service';
import { TranslateService } from '@ngx-translate/core';
import { SampledatamanagementAddDialogComponent } from './sampledatamanagementaddDialog/sampledatamanagementaddDialog.component';
import { MdDialog, MdDialogRef } from '@angular/material';
import { Component, OnInit, ViewChild } from '@angular/core';
import {
    IPageChangeEvent,
    ITdDataTableColumn,
    ITdDataTableSortChangeEvent,
    TdDataTableColumnComponent,
    TdDataTableComponent,
    TdDialogService
} from '@covalent/core';
import { SampledatamanagementDataGridService } from './shared/sampledatamanagementdataGrid.service';
import * as _ from 'lodash';

@Component({
    selector: 'app-sampledatadata-grid',
    templateUrl: './sampledatamanagementdataGrid.component.html',
})

export class SampledatamanagementDataGridComponent implements OnInit {

    @ViewChild('dataTable') dataTable: TdDataTableComponent

    data: any = [];
    columns: ITdDataTableColumn[] = [
      {name: 'name', label: this.getTranslation('sampledatamanagementdatagrid.columns.name')},
    
      {name: 'surname', label: this.getTranslation('sampledatamanagementdatagrid.columns.surname')},
    
      {name: 'age', label: this.getTranslation('sampledatamanagementdatagrid.columns.age')},
    
      {name: 'mail', label: this.getTranslation('sampledatamanagementdatagrid.columns.mail')}
    ];

    selectedRow: any;

    dialogRef: MdDialogRef<SampledatamanagementAddDialogComponent>;

    dataTotal: number;
    searchBox = false;
    currentPage = 1;
    pageSize = 5;
    sorting: any[] = [];
    searchTerms: any = {
      name: null,
      surname: null,
      age: null,
      mail: null
    };

    constructor(public dialog: MdDialog,
                public authService: AuthService,
                public router: Router,
                private dataGridService: SampledatamanagementDataGridService,
                private _dialogService: TdDialogService,
                private translate: TranslateService) {
    }

    ngOnInit(): void {
        this.getData();
    }

    getTranslation(text: string): string {
        let value: string;
        let me = this;

        this.translate.get(text).subscribe( (res) => {
            value = res;
        });

        this.translate.onLangChange.subscribe(() => {
                me.columns.forEach( column => {
                    this.translate.get('sampledatamanagementdatagrid.columns.' + column.name).subscribe( (res) => {
                        column.label = res;
                    });
                });
                me.dataTable.refresh();
        });

        return value;
    }

    getData(): void {
       let me = this;
       this.dataGridService.getData(this.pageSize, this.currentPage, this.searchTerms, this.sorting).subscribe((res) => {
           me.data = res.result;
           me.dataTotal = res.pagination.total;
       }, (error) => {
            this._dialogService.openConfirm({
                message: JSON.parse(error.text()).message,
                title: this.getTranslation('sampledatamanagementdatagrid.alert.title')
            }).afterClosed().subscribe((accept: boolean) => {
              if (accept) {
                this.authService.setLogged(false);
                this.router.navigate(['/login']);
              }
            });
       });
    }

    sort(sortEvent: ITdDataTableSortChangeEvent): void {
        this.sorting = _.reject(this.sorting, { 'name': sortEvent.name });
        this.sorting.push({'name': sortEvent.name, 'direction': sortEvent.order});
        this.getData();
    }

    search(searchForm): void {
        _.forIn(searchForm.value, function(value, key) {
            if (value === '') {
                searchForm.value[key] = null;
            }
        });
        this.searchTerms = searchForm.value;
        this.getData();
    }

    searchReset(form): void {
      form.reset();
      this.search(form);
    }

    openSearchBox() {
        this.searchBox = !this.searchBox;
    }

    page(pagingEvent: IPageChangeEvent): void {
        this.pageSize = pagingEvent.pageSize;
        this.currentPage = pagingEvent.page;
        this.getData();
    }

    selectEvent(e): void {
        e.selected ? this.selectedRow = e.row : this.selectedRow = undefined;
    }

    openDialog(): void {
        this.dialogRef = this.dialog.open(SampledatamanagementAddDialogComponent);

        this.dialogRef.afterClosed().subscribe(result => {
            if (result) {
              this.dataGridService.saveData(result).subscribe( () => {
                  this.getData();
              }, (error) => {
                  this._dialogService.openAlert({
                      message: JSON.parse(error.text()).message,
                      title: this.getTranslation('sampledatamanagementdatagrid.alert.title')
                  }).afterClosed().subscribe((accept: boolean) => {
                    if (accept) {
                    this.authService.setLogged(false);
                    this.router.navigate(['/login']);
                    }
                });
              });
            }
        });
    }

    openEditDialog(): void {
        this.dialogRef = this.dialog.open(SampledatamanagementAddDialogComponent, {
            data: this.selectedRow,
        });

        this.dialogRef.afterClosed().subscribe(result => {
            if (result) {
              this.dataGridService.saveData(result).subscribe( () => {
                  this.getData();
              }, (error) => {
                  this._dialogService.openAlert({
                      message: JSON.parse(error.text()).message,
                      title: this.getTranslation('sampledatamanagementdatagrid.alert.title')
                  }).afterClosed().subscribe((accept: boolean) => {
                      if (accept) {
                        this.authService.setLogged(false);
                        this.router.navigate(['/login']);
                      }
                    });
              });
            }
        });
    }

    openConfirm(): void {
        this._dialogService.openConfirm({
            message: this.getTranslation('sampledatamanagementdatagrid.alert.message'),
            title: this.getTranslation('sampledatamanagementdatagrid.alert.title'),
            cancelButton: this.getTranslation('sampledatamanagementdatagrid.alert.cancelBtn'),
            acceptButton: this.getTranslation('sampledatamanagementdatagrid.alert.acceptBtn'),
        }).afterClosed().subscribe((accept: boolean) => {
            if (accept) {
                this.dataGridService.deleteData(this.selectedRow.id).subscribe( () => {
                    this.getData();
                }, (error) => {
                    this._dialogService.openAlert({
                        message: JSON.parse(error.text()).message,
                        title: this.getTranslation('sampledatamanagementdatagrid.alert.title')
                    }).afterClosed().subscribe((acceptance: boolean) => {
                      if (acceptance) {
                        this.authService.setLogged(false);
                        this.router.navigate(['/login']);
                      }
                    });
                });
            }
        });
    }
}
