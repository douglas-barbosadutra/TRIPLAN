import { Component, OnInit } from '@angular/core';
//import { User } from '../models/User';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
//import { LoginService } from '../services/login.service';
//import { LoginDTO } from '../dto/LoginDTO';
@Component({
    selector: 'app-prova',
    templateUrl: './prova.component.html',
    styleUrls: ['./prova.component.css']
})
export class ProvaComponent implements OnInit {

    //user: User;

    //logindto: LoginDTO= new LoginDTO();
   // username: string="";
    //password: string="";

    constructor( private router: Router) {

    }
    ngOnInit() {
    }
    
    
   
    
  /*  login(): void{

        this.logindto.username=this.username;
        this.logindto.password=this.password;
    
        console.log("USER AND PASSWORD"+this.username+" "+this.password);

        this.loginService.login(this.logindto).subscribe((response: any) => {
          console.log(JSON.stringify(response));
          localStorage.setItem("currentUser", JSON.stringify({ "authorities": response.id_token }));

          console.log("CONTENT USER "+localStorage.getItem("currentUser"));
        
      console.log("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    });
}*/
}