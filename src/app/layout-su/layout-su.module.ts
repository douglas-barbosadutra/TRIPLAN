import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutSuComponent } from './layout-su.component';
import { NavbarSuComponent } from './navbar-su/navbar-su.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    LayoutSuComponent,
    NavbarSuComponent,
  ],
  imports: [
    RouterModule,
    CommonModule
  ]
})
export class LayoutSuModule { }
