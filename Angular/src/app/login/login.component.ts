import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { LoginDTO } from '../dto/LoginDTO';
import { UserDTO } from '../dto/UserDTO';
@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    user: UserDTO;

    private idUtenteLocale: number;
    public loginDTO: LoginDTO;
    public userDTO: UserDTO= new UserDTO();


    logindto: LoginDTO= new LoginDTO();
    username: string="";
    password: string="";

    constructor(private loginService: LoginService, private router: Router) {

    }
    ngOnInit() {
        document.body.classList.add('login');

    }
    
    
   
    
    login(): void{

        this.logindto.username=this.username;
        this.logindto.password=this.password;
    
       // console.log("USER AND PASSWORD"+this.username+" "+this.password);

        this.loginService.login(this.logindto).subscribe((response: any) => {
         // console.log(JSON.stringify(response));
          localStorage.setItem("currentUser", JSON.stringify({ "authorities": response.id_token }));

          if(response != null){

           // this.getLoginData();
            
           this.loginService.getUserLogged(this.username).subscribe((response: any) => {

           // console.log("response" +JSON.stringify(response));

            this.userDTO.id = response.id;
            this.userDTO.role = response.authorities;
            this.userDTO.username = this.password;
            this.userDTO.password = this.username;
            //this.userDTO.type = response.type;
            sessionStorage.setItem("idUser", JSON.stringify(response.idUser));
            sessionStorage.setItem("username", JSON.stringify(response.username));
            sessionStorage.setItem("password", JSON.stringify(response.password));
            sessionStorage.setItem("role", JSON.stringify(response.role));//da verificare al momento id_token
                                                                                        //viene sostituito dal role

            this.idUtenteLocale = response.id;
            var controllo="";
            console.log(this.userDTO.role);
            if(this.userDTO.role.length==1){
              controllo=this.userDTO.role[0];  
            }else{
                controllo=this.userDTO.role[0]+","+this.userDTO.role[1];
            }
            sessionStorage.setItem("idUser", JSON.stringify(this.idUtenteLocale));

            if(controllo == "ROLE_USER,ROLE_ADMIN"){
                this.router.navigateByUrl("/homeBo");
              }
              else //if(response.type == 0)
              alert("Non sono nella pagina segnalta");             
       
           });

        }
        else{
            alert("username o password errati");
              
    }});
}

/*getLoginData(): any {
    this.loginService.Account().subscribe(
        (response) => {
           // this.getPerformanceData();
        },
        (error) => {
            console.error("There was an error getting account data", error);
        }
    );
}*/


}