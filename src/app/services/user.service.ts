import { Injectable } from '@angular/core';
import { UserDTO } from 'src/app/dto/userdto';
import { HttpClient, HttpParams } from '@angular/common/http';
import { AbstractService } from './abstract.service';
import { Observable } from 'rxjs';
import { LoginDTO } from '../dto/logindto';

@Injectable({
  providedIn: 'root'
})

export class UserService extends AbstractService<UserDTO> {

    constructor(shttp: HttpClient) {
        super(shttp);
        this.type = 'user';
    }


    login(loginDTO: LoginDTO): Observable<UserDTO> {
        return this.http.post<any>('http://localhost:8080/user/login', loginDTO);
  }

}