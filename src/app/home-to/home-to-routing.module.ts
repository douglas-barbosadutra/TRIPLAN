import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutToComponent } from '../layout-to/layout-to.component';
import { HomeToComponent } from './home-to.component';
import { GhusListComponent } from './ghus-list/ghus-list.component';
import { GhusInsertComponent } from './ghus-insert/ghus-insert.component';
import { CityListComponent } from './city-list/city-list.component';
import { CityInsertComponent } from './city-insert/city-insert.component';


const routes: Routes = [
            { path: 'hometo', component: LayoutToComponent, children: [
            {path: '', component: HomeToComponent},
            {path: 'showUser', component: GhusListComponent},
            {path: 'insertUser', component: GhusListComponent},
            {path: 'showCity', component: CityListComponent},
            {path: 'insertCity', component: CityInsertComponent}

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
export class HomeToRoutingModule { }