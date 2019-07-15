import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginModule } from './login/login.module';
import { ProvaComponent } from './page/prova/prova.component';

@NgModule({
  declarations: [
    AppComponent,
    ProvaComponent,
    
    
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
	AppRoutingModule,
  LoginModule,
  
 


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
