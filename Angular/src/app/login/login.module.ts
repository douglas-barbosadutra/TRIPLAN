import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login.component';
import { FormsModule } from '@angular/forms';
import { MaterialModule } from '../material.module';


@NgModule({
  declarations: [
    LoginComponent,

  ],
  imports: [
    CommonModule,
    FormsModule,
    MaterialModule
  ]
})
export class LoginModule { }
