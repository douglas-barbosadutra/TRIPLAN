import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarToComponent } from './navbar-to/navbar-to.component';
import { LayoutToComponent } from './layout-to.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    LayoutToComponent,
    NavbarToComponent,
    ],
    imports: [
    RouterModule,
    CommonModule
  ]
})
export class LayoutToModule { }
