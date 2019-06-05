import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeUserRoutingModule } from './home-user-routing.module';
import { FormsModule } from '@angular/forms';
import { HomeUserComponent } from './home-user.component';

@NgModule({
  declarations: [
    HomeUserComponent
  ],
  imports: [
    CommonModule,
    HomeUserRoutingModule,
    FormsModule
  ]
})
export class HomeUserModule { }
