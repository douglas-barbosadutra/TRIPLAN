import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { LoginService } from '../services/login.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    user: User;

    constructor(private loginService: LoginService, private router: Router) {

    }
    ngOnInit() {
    }

    login(f: NgForm): void {
        this.loginService.login(f.value.username, f.value.password).subscribe((response) => {
            if (response != null) {
                this.user = response;
                sessionStorage.setItem('user', JSON.stringify(this.user));
                if (response.userType === 'superuser') {
                    this.router.navigateByUrl('/homesu');
                } else if (response.userType === 'touroperator') {
                    this.router.navigateByUrl('/hometo');
                } else if (response.userType === 'gestorehotel') {
                    this.router.navigateByUrl('/homegh');
                } else if (response.userType === 'gestoreeventi') {
                    this.router.navigateByUrl('/homege');
                } else if (response.userType === 'user') {
                    this.router.navigateByUrl('/homeuser');
                }
            }
        });
    }
}

