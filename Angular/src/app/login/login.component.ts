import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { LoginService } from '../services/login.service';
import { LoginDTO } from '../dto/LoginDTO';
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
    
    logindto: LoginDTO
   
    
    login(): void{
        this.loginService.login(this.logindto).subscribe((response: any) => {
          console.log(JSON.stringify(response));
          localStorage.setItem("currentUser", JSON.stringify({ "authorities": response.id_token }));
        
      console.log("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    });
}
}