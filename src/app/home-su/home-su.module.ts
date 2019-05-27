import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeSuComponent } from './home-su.component';
import { HomeSuRoutingModule } from './home-su-routing.module';
import { TogeListComponent } from './toge-list/toge-list.component';
import { TogeInsertComponent } from './toge-insert/toge-insert.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    HomeSuComponent,
    TogeListComponent,
    TogeInsertComponent,

  ],
  imports: [
    CommonModule,
    HomeSuRoutingModule,
    FormsModule
  ]
})
export class HomeSuModule { }
