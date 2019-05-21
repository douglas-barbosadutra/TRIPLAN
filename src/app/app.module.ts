import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { UsersComponent } from '../app/component/user/user.component';
import { HeaderComponent } from '../app/component/header/header.component';
import { MenuComponent } from './component/menu/menu.component';
import { LoginComponent } from '../app/component/login/login.component';
import { SuperuserDashboardComponent } from './component/dashboard/superuser-dashboard/superuser-dashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    HeaderComponent,
    LoginComponent,
    SuperuserDashboardComponent,
    MenuComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
