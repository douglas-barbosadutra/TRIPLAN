import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Image } from '../models/Image';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private http: HttpClient) {}
    insertImage(image: Image) {
    return this.http.post( 'http://localhost:8080/image/insertImage', image);
  }

  showImage(): Observable<Image[]> {
    return this.http.get<Image[]>('http://localhost:8080/image/showImage');
  }

  deleteImage(idImage: number) {
    return this.http.delete('http://localhost:8080/image/deleteImage?idImage=' + idImage);
  }

  updateImage(image: Image) {
    return this.http.put( 'http://localhost:8080/image/updateImage', image);
  }
    selectImage(image: Image) {
    return this.http.post('http://localhost:8080/image/selectImage', image);
  }

 }



