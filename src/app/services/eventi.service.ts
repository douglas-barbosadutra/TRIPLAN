import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Eventi } from '../models/Eventi';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventiService {

  constructor(private http: HttpClient) {}
    insertEvento(eventi: Eventi) {
    return this.http.post( 'http://localhost:8080/Eventi/insert', eventi);
  }

  showEventi(): Observable<Eventi[]> {
    return this.http.get<Eventi[]>('http://localhost:8080/Eventi/showEventi');
  }

  deleteEvento(idEvento: number) {
    return this.http.delete('http://localhost:8080/Eventi/delete?idEvento=' + idEvento);
  }

  updateEvento(eventi: Eventi) {
    return this.http.put( 'http://localhost:8080/Eventi/update', eventi);
  }
 }



