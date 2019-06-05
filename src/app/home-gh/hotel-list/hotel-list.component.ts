import { Component, OnInit } from '@angular/core';
import { Hotel } from '../../models/Hotel';
import { HotelService } from '../../services/hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hotel-list',
  templateUrl: './hotel-list.component.html',
  styleUrls: ['./hotel-list.component.css']
})
export class HotelListComponent implements OnInit {
  hotelList: Hotel[];
  hotel: Hotel;


  constructor(private hotelService: HotelService, private router: Router) { }

  ngOnInit() {
   this.hotelService.showHotel().subscribe((data: any) =>{

      if(data != null){
        this.hotelList = data;
      }
    })
  }

    deleteHotel(idHotel: number) {
      this.hotelService.deleteHotel(idHotel).subscribe((data: any) => {
        this.router.navigateByUrl('homegh');
      });
    }
}