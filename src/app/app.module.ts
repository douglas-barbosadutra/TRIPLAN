import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutSuModule } from './layout-su/layout-su.module';
import { LoginModule } from './login/login.module';
import { HomeSuModule } from './home-su/home-su.module';
import { LayoutToModule } from './layout-to/layout-to.module';
import { HomeToModule } from './home-to/home-to.module';
import { LayoutGhModule } from './layout-gh/layout-gh.module';
import { HomeGhModule } from './home-gh/home-gh.module';
import { LayoutGeModule } from './layout-ge/layout-ge.module';
import { HomeGeModule } from './home-ge/home-ge.module';
import { LayoutUserModule } from './layout-user/layout-user.module';
import { HomeUserModule } from './home-user/home-user.module';


@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    LayoutSuModule,
    LoginModule,
    HomeSuModule,
    LayoutToModule,
    HomeToModule,
    LayoutGhModule,
    HomeGhModule,
    LayoutGeModule,
    HomeGeModule,
    LayoutUserModule,
    HomeUserModule,

],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
