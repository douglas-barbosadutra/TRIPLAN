import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LayoutGhComponent } from './layout-gh.component';
import { NavbarGhComponent } from './navbar-gh/navbar-gh.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    LayoutGhComponent,
    NavbarGhComponent,
  ],
  imports: [
    RouterModule,
    CommonModule
  ]
})
export class LayoutGhModule { }
