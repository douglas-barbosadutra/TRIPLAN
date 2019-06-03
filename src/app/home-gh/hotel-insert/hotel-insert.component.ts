import { Component, OnInit } from '@angular/core';
import { Hotel } from '../../models/Hotel';
import { HotelService } from '../../services/hotel.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-hotel-insert',
  templateUrl: './hotel-insert.component.html',
  styleUrls: ['./hotel-insert.component.css']
})
export class HotelInsertComponent implements OnInit {
  public hotel: Hotel;

  constructor(private hotelService: HotelService, private router: Router) { }

  ngOnInit() {
    this.hotel = new Hotel(0, '', 0, 0, null , 0, null);
  }

    insertHotel(f: NgForm) {

    this.hotelService.insertHotel(this.hotel).subscribe((data: any) => {
        alert('Inserimento effettuato');
      this.router.navigateByUrl('/homegh');
    });
  }

}
