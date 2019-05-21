import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersComponent } from '../app/component/user/user.component';
import { UserDetailComponent } from '../app/component/user/user-detail/user-detail.component';
import { LoginComponent } from '../app/component/login/login.component';
import { SuperuserDashboardComponent } from './component/dashboard/superuser-dashboard/superuser-dashboard.component';



const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent},
    { path: 'user', component: UsersComponent },
    { path: 'detail/:id', component: UserDetailComponent },
    { path: 'superuser-dashboard', component: SuperuserDashboardComponent},


    ];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
