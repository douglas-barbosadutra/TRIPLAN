import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule } from './login/login.module';
import { LayoutAdminModule } from './layout-admin/layout-admin.module';
import { HomeAdminModule } from './home-admin/home-admin.module';

@NgModule({
  declarations: [
    AppComponent,    
    
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
	  AppRoutingModule,
    LoginModule,
    LayoutAdminModule,
    HomeAdminModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
