import { Component, OnInit } from '@angular/core';
import { City } from '../../models/City';
import { CityService } from '../../services/city.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit {
  cityList: City[];
  city: City;


  constructor(private cityService: CityService, private router: Router) { }

  ngOnInit() {
   this.cityService.showCity().subscribe((data: any) =>{

      if(data != null){
        this.cityList = data;
      }
    })
  }

    deleteCity(idCity: number) {
      this.cityService.deleteCity(idCity).subscribe((data: any) => {
        this.router.navigateByUrl('hometo');
      });
    }
}