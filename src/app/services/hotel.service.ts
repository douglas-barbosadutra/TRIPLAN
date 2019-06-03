import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Hotel } from '../models/Hotel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private http: HttpClient) {}
    insertHotel(hotel: Hotel) {
    return this.http.post( 'http://localhost:8080/Hotel/insert', hotel);
  }

  showHotel(): Observable<Hotel[]> {
    return this.http.get<Hotel[]>('http://localhost:8080/Hotel/showHotel');
  }

  deleteHotel(idHotel: number) {
    return this.http.delete('http://localhost:8080/Hotel/delete?idHotel=' + idHotel);
  }

  updateHotel(hotel: Hotel) {
    return this.http.put( 'http://localhost:8080/Hotel/update', hotel);
  }

  findHotel(idHotel: number) {
          return this.http.get('http://localhost:8080/Hotel/findHotel?idHotel=' + idHotel);
  }
 }



