import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeGeComponent } from './home-ge.component';
import { FormsModule } from '@angular/forms';
import { HomeGeRoutingModule } from './home-ge-routing.module';
import { EventiListComponent } from './eventi-list/eventi-list.component';
import { EventiInsertComponent } from './eventi-insert/eventi-insert.component';

@NgModule({
  declarations: [
      HomeGeComponent,
      EventiListComponent,
      EventiInsertComponent,
  ],
  imports: [
    CommonModule,
    HomeGeRoutingModule,
    FormsModule
  ]
})
export class HomeGeModule { }
