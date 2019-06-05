import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarUserComponent } from './navbar-user/navbar-user.component';
import { LayoutUserComponent } from './layout-user.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    NavbarUserComponent,
    LayoutUserComponent,
    ],
  imports: [
    RouterModule,
    CommonModule
    ]
})
export class LayoutUserModule { }
