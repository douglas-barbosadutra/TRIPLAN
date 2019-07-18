import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutAdminComponent } from '../layout-admin/layout-admin.component';
import { HomeAdminComponent } from './home-admin.component';
import { UserListComponent } from './user-list/user-list.component';


const routes: Routes = [
            { path: 'homeBo', component: LayoutAdminComponent, children: [
            {path: '', component: HomeAdminComponent},
            {path: 'showUser', component: UserListComponent},


            
        ] },

];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(routes),

  ],
  exports: [
    RouterModule
  ]
})
export class HomeAdminRoutingModule { }
