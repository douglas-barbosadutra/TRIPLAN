import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeAdminComponent } from './home-admin.component';
import { HomeAdminRoutingModule } from './home-admin-routing.module';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from '../material.module';
import { UserListComponent } from './user-list/user-list.component';



@NgModule({
  declarations: [
    HomeAdminComponent,
    UserListComponent,
  ],
  imports: [
    CommonModule,
    HomeAdminRoutingModule,
    FormsModule,
    MaterialModule
  ]
})
export class HomeAdminModule { }
