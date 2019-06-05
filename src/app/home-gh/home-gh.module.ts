import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeGhComponent } from './home-gh.component';
import { HomeGhRoutingModule } from './home-gh-routing.module';
import { HotelListComponent } from './hotel-list/hotel-list.component';
import { HotelInsertComponent } from './hotel-insert/hotel-insert.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    HomeGhComponent,
    HotelListComponent,
    HotelInsertComponent,

  ],
  imports: [
    CommonModule,
    HomeGhRoutingModule,
    FormsModule
  ]
})
export class HomeGhModule { }
