import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutGeComponent } from '../layout-ge/layout-ge.component';
import { HomeGeComponent } from './home-ge.component';
import { EventiListComponent } from './eventi-list/eventi-list.component';
import { EventiInsertComponent } from './eventi-insert/eventi-insert.component';


const routes: Routes = [
            { path: 'homege', component: LayoutGeComponent, children: [
            {path: '', component: HomeGeComponent},
            {path: 'showEvento', component: EventiListComponent},
            {path: 'insertEvento', component: EventiInsertComponent},
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
export class HomeGeRoutingModule { }