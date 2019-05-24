import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeSuComponent } from './home-su.component';
import { HomeSuRoutingModule } from './home-su-routing.module';
import { UserListComponent } from './user-list/user-list.component';


@NgModule({
  declarations: [
    HomeSuComponent,
    UserListComponent,

  ],
  imports: [
    CommonModule,
    HomeSuRoutingModule
  ]
})
export class HomeSuModule { }
