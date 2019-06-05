import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutGeComponent } from './layout-ge.component';
import { NavbarGeComponent } from './navbar-ge/navbar-ge.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    LayoutGeComponent,
    NavbarGeComponent,
  ],
  imports: [
    RouterModule,
    CommonModule
  ]
})
export class LayoutGeModule { }
