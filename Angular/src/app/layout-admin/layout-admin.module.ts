import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarAdminComponent } from './navbar-admin/navbar-admin.component';
import { LayoutAdminComponent } from './layout-admin.component';
import { RouterModule } from '@angular/router';
import { MaterialModule } from '../material.module';



@NgModule({
  declarations: [
    LayoutAdminComponent,
    NavbarAdminComponent,
  ],
  imports: [
    RouterModule,
    CommonModule,
    MaterialModule
  ]
})
export class LayoutAdminModule { }
