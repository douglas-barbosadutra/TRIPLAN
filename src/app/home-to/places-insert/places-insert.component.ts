import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Places } from '../../models/Places';
import {PlacesService} from '../../services/places.service';

@Component({
  selector: 'app-places-insert',
  templateUrl: './places-insert.component.html',
  styleUrls: ['./places-insert.component.css']
})
export class PlacesInsertComponent implements OnInit {
  public places: Places;

  constructor(private placesService: PlacesService, private router: Router) { }

  ngOnInit() {
    this.places = new Places(0, '', 0, 0, '', 0);
  }

    insertPlaces(f: NgForm) {

    this.placesService.insertPlaces(this.places).subscribe((data: any) => {

      if (data != null) {
        alert('Inserimento effettuato');
      } else {
        alert('Inserimento fallito');
      }

      this.router.navigateByUrl('/hometo');
    });
  }

}
