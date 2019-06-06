import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { City } from '../models/City';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  constructor(private http: HttpClient) {}
    insertCity(city: City) {
    return this.http.post( 'http://localhost:8080/City/insert', city);
  }

  showCity(): Observable<City[]> {
    return this.http.get<City[]>('http://localhost:8080/City/showCity');
  }

  deleteCity(idCity: number) {
    return this.http.delete('http://localhost:8080/City/delete?idCity=' + idCity);
  }

  updateCity(city: City) {
    return this.http.put( 'http://localhost:8080/City/update', city);
  }
 }



