import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutSuComponent } from '../layout-su/layout-su.component';
import { HomeSuComponent } from './home-su.component';
import { TogeListComponent } from './toge-list/toge-list.component';
import { TogeInsertComponent } from './toge-insert/toge-insert.component';


const routes: Routes = [
            { path: 'homesu', component: LayoutSuComponent, children: [
            {path: '', component: HomeSuComponent},
            {path: 'showUser', component: TogeListComponent},
            {path: 'insertUser', component: TogeInsertComponent},

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
