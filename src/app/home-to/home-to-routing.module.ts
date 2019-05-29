import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutToComponent } from '../layout-to/layout-to.component';
import { HomeToComponent } from './home-to.component';
import { GhusListComponent } from './ghus-list/ghus-list.component';
import { GhusInsertComponent } from './ghus-insert/ghus-insert.component';
import { CityListComponent } from './city-list/city-list.component';
import { CityInsertComponent } from './city-insert/city-insert.component';
import { PlacesListComponent } from './places-list/places-list.component';
import { PlacesInsertComponent } from './places-insert/places-insert.component';


const routes: Routes = [
            { path: 'hometo', component: LayoutToComponent, children: [
            {path: '', component: HomeToComponent},
            {path: 'showUser', component: GhusListComponent},
            {path: 'insertUser', component: GhusInsertComponent},
            {path: 'showCity', component: CityListComponent},
            {path: 'insertCity', component: CityInsertComponent},
            {path: 'showPlaces', component: PlacesListComponent},
            {path: 'insertPlaces', component: PlacesInsertComponent},

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