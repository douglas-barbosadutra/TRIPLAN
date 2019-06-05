import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutGhComponent } from '../layout-gh/layout-gh.component';
import { HomeGhComponent } from './home-gh.component';
import { HotelListComponent } from './hotel-list/hotel-list.component';
import { HotelInsertComponent } from './hotel-insert/hotel-insert.component';


const routes: Routes = [
            { path: 'homegh', component: LayoutGhComponent, children: [
            {path: '', component: HomeGhComponent},
            {path: 'showHotel', component: HotelListComponent},
            {path: 'insertHotel', component: HotelInsertComponent},

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
export class HomeGhRoutingModule { }