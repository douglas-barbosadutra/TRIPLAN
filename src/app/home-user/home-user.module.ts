import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeUserRoutingModule } from './home-user-routing.module';
import { FormsModule } from '@angular/forms';
import { HomeUserComponent } from './home-user.component';
import { SelectImageComponent } from './select-image/select-image.component';

@NgModule({
  declarations: [
    HomeUserComponent,
    SelectImageComponent
  ],
  imports: [
    CommonModule,
    HomeUserRoutingModule,
    FormsModule
  ]
})
export class HomeUserModule { }
