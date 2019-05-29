import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Places } from '../models/Places';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlacesService {

  constructor(private http: HttpClient) {}
    insertPlaces(places: Places) {
    return this.http.post( 'http://localhost:8080/Places/insert', places);
  }

  showPlaces(): Observable<Places[]> {
    return this.http.get<Places[]>('http://localhost:8080/Places/showPlaces');
  }

  deletePlaces(idPlaces: number) {
    return this.http.delete('http://localhost:8080/Places/delete?idPlaes=' + idPlaces);
  }

  updateCity(places: Places) {
    return this.http.put( 'http://localhost:8080/Places/update', places);
  }

  findCity(idPlaces: number) {
          return this.http.get('http://localhost:8080/Places/findPlaces?idPlaces=' + idPlaces);
  }
 }



