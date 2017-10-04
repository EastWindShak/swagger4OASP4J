<td-layout-nav>
  <div td-toolbar-content flex>
    <app-header></app-header>
  </div>
  <td-layout-manage-list opened="true" mode="side" sidenavWidth="350px">

    <md-nav-list td-sidenav-content>
      <a id="home" md-list-item [routerLink]="['./initialPage']">
        <md-icon md-list-avatar>home</md-icon>
        <h3 md-line> {{'${variables.component}.${variables.entityName}.navHome' | translate}} </h3>
        <p md-line> {{'${variables.component}.${variables.entityName}.navHomeSub' | translate}} </p>
      </a>

      <a id="${variables.entityName}" md-list-item [routerLink]="['./${variables.entityName}']">
        <md-icon md-list-avatar>grid_on</md-icon>
        <h3 md-line> {{'${variables.component}.${variables.entityName}.navData' | translate}} </h3>
        <p md-line> {{'${variables.component}.${variables.entityName}.navDataSub' | translate}} </p>
      </a>
    </md-nav-list>

    <router-outlet></router-outlet>

  </td-layout-manage-list>
</td-layout-nav>
