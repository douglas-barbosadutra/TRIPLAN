import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutUserComponent } from '../layout-user/layout-user.component';
import { HomeUserComponent } from './home-user.component';



const routes: Routes = [
            { path: 'homeuser', component: LayoutUserComponent, children: [
            {path: '', component: HomeUserComponent},
        ] },
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(routes),

  ],
  exports: [
    RouterModule
  ]
})
export class HomeUserRoutingModule { }
