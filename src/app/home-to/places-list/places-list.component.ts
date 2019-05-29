import { Component, OnInit } from '@angular/core';
import { Places } from '../../models/Places';
import { PlacesService } from '../../services/places.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-places-list',
  templateUrl: './places-list.component.html',
  styleUrls: ['./places-list.component.css']
})
export class PlacesListComponent implements OnInit {
  placesList: Places[];
  places: Places;


  constructor(private placesService: PlacesService, private router: Router) { }

  ngOnInit() {
   this.placesService.showPlaces().subscribe((data: any) =>{

      if(data != null){
        this.placesList = data;
      }
    })
  }

    deleteCity(idPlaces: number) {
      this.placesService.deletePlaces(idPlaces).subscribe((data: any) => {
        this.router.navigateByUrl('hometo');
      });
    }
}