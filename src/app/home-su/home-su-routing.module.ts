import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from '../layout/layout.component';
import { HomeSuComponent } from './home-su.component';
import { UserListComponent } from './user-list/user-list.component';


const routes: Routes = [
        { path: 'homesu', component: LayoutComponent, children: [
            {path: '', component: HomeSuComponent},
            {path: 'showUser', component: UserListComponent}

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
export class HomeSuRoutingModule { }
