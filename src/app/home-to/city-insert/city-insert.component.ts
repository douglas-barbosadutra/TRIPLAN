import { Component, OnInit } from '@angular/core';
import { City } from '../../models/City';
import { CityService } from '../../services/city.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-city-insert',
  templateUrl: './city-insert.component.html',
  styleUrls: ['./city-insert.component.css']
})
export class CityInsertComponent implements OnInit {
  public city: City;

  constructor(private cityService: CityService, private router: Router) { }

  ngOnInit() {
    this.city = new City(0, '', '');
  }

    insertCity(f: NgForm) {

    this.cityService.insertCity(this.city).subscribe((data: any) => {
        alert('Inserimento effettuato');
      this.router.navigateByUrl('/hometo');
    });
  }

}
