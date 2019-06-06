import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}
    insertUser(user: User) {
    return this.http.post( 'http://localhost:8080/user/insertUser', user);
  }

  showUser(): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8080/user/showUser');
  }

  deleteUser(idUser: number) {
    return this.http.delete('http://localhost:8080/user/deleteUser?idUser=' + idUser);
  }

  updateUser(user: User) {
    return this.http.put( 'http://localhost:8080/user/updateUser', user);
  }
 }



