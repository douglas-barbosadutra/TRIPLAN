import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeToComponent } from './home-to.component';
import { FormsModule } from '@angular/forms';
import { HomeToRoutingModule } from './home-to-routing.module';
import { GhusListComponent } from './ghus-list/ghus-list.component';
import { GhusInsertComponent } from './ghus-insert/ghus-insert.component';
import { CityListComponent } from './city-list/city-list.component';
import { CityInsertComponent } from './city-insert/city-insert.component';
import { PlacesListComponent } from './places-list/places-list.component';
import { PlacesInsertComponent } from './places-insert/places-insert.component';

@NgModule({
  declarations: [
      HomeToComponent,
      GhusListComponent,
      GhusInsertComponent,
      CityListComponent,
      CityInsertComponent,
      PlacesListComponent,
      PlacesInsertComponent,
  ],
  imports: [
    CommonModule,
    HomeToRoutingModule,
    FormsModule
  ]
})
export class HomeToModule { }
