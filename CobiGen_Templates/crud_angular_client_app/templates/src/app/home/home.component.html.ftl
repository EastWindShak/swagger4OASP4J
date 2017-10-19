<td-layout-nav>
  <div td-toolbar-content flex>
    <app-header></app-header>
  </div>
  <td-layout-manage-list opened="true" mode="side" sidenavWidth="350px">

    <md-nav-list td-sidenav-content>
      <a id="home" md-list-item [routerLink]="['./initialPage']">
        <md-icon md-list-avatar>home</md-icon>
        <h3 md-line> {{'${variables.component}.${variables.etoName}.navHome' | translate}} </h3>
        <p md-line> {{'${variables.component}.${variables.etoName}.navHomeSub' | translate}} </p>
      </a>

      <a id="${variables.etoName}" md-list-item [routerLink]="['./${variables.etoName?lower_case}']">
        <md-icon md-list-avatar>grid_on</md-icon>
        <h3 md-line> {{'${variables.component}.${variables.etoName}.navData' | translate}} </h3>
        <p md-line> {{'${variables.component}.${variables.etoName}.navDataSub' | translate}} </p>
      </a>
    </md-nav-list>

    <router-outlet></router-outlet>

  </td-layout-manage-list>
</td-layout-nav>